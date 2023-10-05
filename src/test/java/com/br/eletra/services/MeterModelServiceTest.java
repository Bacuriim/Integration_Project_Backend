package com.br.eletra.services;

import com.br.eletra.models.MeterCategoryEntity;
import com.br.eletra.models.MeterModelEntity;
import com.br.eletra.repository.ModelRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
    private ModelRepo modelRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void searchModelNameByCategoryNameTest() {
        MeterModelEntity mockModel = new MeterModelEntity("Ares 7021" , (short) 1);
        MeterCategoryEntity mockCategory = new MeterCategoryEntity("Ares TB" , (short) 0);

        when(modelRepo.findByCategoryId(mockCategory.getId())).thenReturn(Collections.singletonList(mockModel));

        List<MeterModelEntity> result = modelService.getModelNameByCategoryName(mockCategory.getCategoryName());

        assertEquals(Collections.singletonList(mockModel) , result);
        verify(modelRepo).findByCategoryId(mockCategory.getId());
        verifyNoMoreInteractions(modelRepo);
    }


}
