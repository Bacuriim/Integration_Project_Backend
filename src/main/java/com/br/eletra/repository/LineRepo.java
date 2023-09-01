package com.br.eletra.repository;

import com.br.eletra.models.MeterCategoryEntity;
import com.br.eletra.models.MeterLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepo extends JpaRepository<MeterLineEntity, String> {

	MeterLineEntity findByLineName(String lineName);

	void delete(MeterLineEntity meterLineEntity);

}
