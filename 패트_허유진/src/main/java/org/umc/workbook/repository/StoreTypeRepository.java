package org.umc.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umc.workbook.domain.StoreType;

public interface StoreTypeRepository extends JpaRepository<StoreType, Long> {
}
