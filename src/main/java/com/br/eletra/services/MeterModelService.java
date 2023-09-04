package com.br.eletra.services;

import com.br.eletra.models.MeterCategoryEntity;
import com.br.eletra.models.MeterModelEntity;
import com.br.eletra.repository.CategoryRepo;
import com.br.eletra.repository.ModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterModelService {
    @Autowired
    private ModelRepo modelRepo;

    @Autowired
    private MeterCategoryService meterCategoryService;

    public List<MeterModelEntity> getModelNameByCategoryName(String categoryName) {
        Short categoryId = meterCategoryService.getCategoryIdByCategoryName(categoryName);
        return modelRepo.findByCategoryId(categoryId);
    }
}
