package org.umc.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umc.workbook.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
