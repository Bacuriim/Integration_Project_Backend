package com.br.eletra.repository;

import com.br.eletra.models.MeterModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<MeterModelEntity, String> {

		MeterModelEntity findByModelName(String modelName);

		MeterModelEntity save(MeterModelEntity meterModelEntity);

		void delete(MeterModelEntity meterModelEntity);
}