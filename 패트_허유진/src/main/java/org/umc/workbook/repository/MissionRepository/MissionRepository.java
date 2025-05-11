package org.umc.workbook.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umc.workbook.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
