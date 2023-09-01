package com.br.eletra.repository;

import com.br.eletra.models.MeterCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<MeterCategoryEntity, String> {

	List<MeterCategoryEntity> findByLineId(Short lineId);

	MeterCategoryEntity findByCategoryName(String categoryName);

	void delete(MeterCategoryEntity meterCategoryEntity);
}