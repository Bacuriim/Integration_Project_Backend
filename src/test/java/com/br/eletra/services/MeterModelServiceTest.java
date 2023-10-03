package com.br.eletra.services;

import com.br.eletra.models.MeterCategoryEntity;
import com.br.eletra.models.MeterModelEntity;
import com.br.eletra.repository.ModelRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MeterModelServiceTest {

    @InjectMocks
    MeterModelService modelService;

    @Mock
    private MeterCategoryService categoryService;

    @Mock
    private ModelRepo modelRepo;

    private MeterModelEntity model = new MeterModelEntity("Ares 7021" , (short) 1);

    private MeterCategoryEntity category = new MeterCategoryEntity("Ares TB" , (short) 0);

    @Test
    public void searchModelNameByCategoryName() {
        when(modelRepo.findByCategoryId(category.getId())).thenReturn(Collections.singletonList(model));

        List<MeterModelEntity> result = modelService.getModelNameByCategoryName(category.getCategoryName());

        assertEquals(Collections.singletonList(model) , result);
        verify(modelRepo).findByCategoryId(category.getId());
        verifyNoMoreInteractions(modelRepo);
    }


}
