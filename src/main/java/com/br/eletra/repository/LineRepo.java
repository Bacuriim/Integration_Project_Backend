package com.br.eletra.repository;

import com.br.eletra.models.MeterLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineRepo extends JpaRepository<MeterLineEntity, String> {

		MeterLineEntity findByLineName(String lineName);

		MeterLineEntity save(MeterLineEntity meterLineEntity);

		void delete(MeterLineEntity meterLineEntity);
}
