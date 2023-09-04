package com.br.eletra.services;

import com.br.eletra.models.MeterLineEntity;
import com.br.eletra.repository.LineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeterLineService {

    @Autowired
    private LineRepo lineRepo;

    public Short getLineIdByLineName(String lineName) {
        MeterLineEntity meterLineEntity = lineRepo.findByLineName(lineName);
        return meterLineEntity.getId();
    }

}
