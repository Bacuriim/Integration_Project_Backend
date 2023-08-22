package com.br.eletra.repository;

import com.br.eletra.models.MeterCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<MeterCategoryEntity, String> {

		MeterCategoryEntity findByCategoryName(String categoryName);

		MeterCategoryEntity save(MeterCategoryEntity meterCategoryEntity);

		void delete(MeterCategoryEntity meterCategoryEntity);
}