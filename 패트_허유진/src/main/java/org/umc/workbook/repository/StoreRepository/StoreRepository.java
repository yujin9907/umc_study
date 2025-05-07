package org.umc.workbook.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umc.workbook.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
