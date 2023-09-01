package com.br.eletra.repository;

import com.br.eletra.models.MeterCategoryEntity;
import com.br.eletra.models.MeterModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepo extends JpaRepository<MeterModelEntity, String> {

	MeterModelEntity findByModelName(String modelName);

	List<MeterModelEntity> findByCategoryId(Short categoryId);

	void delete(MeterModelEntity meterModelEntity);
}