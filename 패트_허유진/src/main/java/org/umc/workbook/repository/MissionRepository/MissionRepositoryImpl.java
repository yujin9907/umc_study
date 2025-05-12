package org.umc.workbook.repository.MissionRepository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.umc.workbook.domain.Mission;
import org.umc.workbook.domain.QMission;
import org.umc.workbook.domain.enums.MissionStatus;
import org.umc.workbook.domain.mapping.MemberMission;

import java.time.LocalDateTime;
import java.util.List;

import static org.umc.workbook.domain.QMember.member;
import static org.umc.workbook.domain.QMission.mission;
import static org.umc.workbook.domain.QRegion.region;
import static org.umc.workbook.domain.QStore.store;
import static org.umc.workbook.domain.mapping.QMemberMission.memberMission;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    @Value("${page.limit}")
    private int limit;


    @Override
    public List<MemberMission> findMissionByMemberPaging(Long memberId, Integer lastReward, LocalDateTime lastCreatedAt, Long lastMissionId) {
        List<MemberMission> result = jpaQueryFactory
                .select(memberMission)
                .from(memberMission)
                .leftJoin(memberMission.mission).fetchJoin()
                .leftJoin(memberMission.member).fetchJoin()
                .leftJoin(memberMission.mission.store).fetchJoin()
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.in(List.of(MissionStatus.PROGRESS, MissionStatus.SUCCESS)),
                        cursorPredicate(mission, lastReward, lastCreatedAt, lastMissionId)
                )
                .orderBy(
                        mission.reward.desc(),
                        mission.createdAt.desc(),
                        mission.id.desc()
                )
                .limit(limit)
                .fetch();
        return result;
    }

    @Override
    public List<Mission> findHoneMissionPaging(Long lastMissionId, Long memberId) {
        List<Mission> results = jpaQueryFactory
                .select(mission)
                .from(mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(
                        //region.name.eq(region.name),
                        mission.deadline.gt(LocalDateTime.now()),
                        mission.id.lt(lastMissionId),
                        mission.id.notIn(
                                JPAExpressions
                                        .select(memberMission.mission.id)
                                        .from(memberMission)
                                        .where(memberMission.member.id.eq(memberId))
                        )
                )
                .orderBy(mission.id.desc())
                .limit(10)
                .fetch();

        return results;
    }

    private BooleanExpression cursorPredicate(QMission m, Integer reward, LocalDateTime createdAt, Long id) {
        if (reward == null || createdAt == null || id == null) {
            return null;
        }

        return m.reward.lt(reward)
                .or(m.reward.eq(reward).and(m.createdAt.lt(createdAt)))
                .or(m.reward.eq(reward).and(m.createdAt.eq(createdAt)).and(m.id.lt(id)));
    }
}
