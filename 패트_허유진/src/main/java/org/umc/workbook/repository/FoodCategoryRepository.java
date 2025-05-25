package org.umc.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umc.workbook.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
