package org.umc.workbook.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import org.umc.workbook.domain.Member;
import org.umc.workbook.domain.Mission;
import org.umc.workbook.domain.common.BaseEntity;
import org.umc.workbook.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "member_mission")
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @Column(nullable = false, length = 20)
    private String missionKey;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Mission mission;
}

