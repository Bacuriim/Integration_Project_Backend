package com.br.eletra.services;

import com.br.eletra.models.MeterCategoryEntity;
import com.br.eletra.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterCategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private MeterLineService meterLineService;

    public List<MeterCategoryEntity> getCategoriesByLineName(String lineName) {
        Short lineId = meterLineService.getLineIdByLineName(lineName);
        return categoryRepo.findByLineId(lineId);
    }

    public Short getCategoryIdByCategoryName(String categoryName) {
        MeterCategoryEntity meterCategory = categoryRepo.findByCategoryName(categoryName);
        return meterCategory.getId();
    }

}
