package com.br.eletra.repository;

import com.br.eletra.model.MeterLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineRepo extends JpaRepository<MeterLineEntity, String> {

    MeterLineEntity findByLineNameIgnoreCase(String name);

    MeterLineEntity save(MeterLineEntity meterLineEntity);

    List<MeterLineEntity> findAll();
}
