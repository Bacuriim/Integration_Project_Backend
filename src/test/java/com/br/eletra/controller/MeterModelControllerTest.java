package com.br.eletra.controller;

import com.br.eletra.models.MeterCategoryEntity;
import com.br.eletra.models.MeterModelEntity;
import com.br.eletra.repository.ModelRepo;
import com.br.eletra.services.MeterModelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MeterModelControllerTest {

    @InjectMocks
    MeterModelController controller;

    @Mock
    private ModelRepo repository;

    @Mock
    private MeterModelService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetModelEntityList() {
        List<MeterModelEntity> mockModelList = new ArrayList<>();
        mockModelList.add(new MeterModelEntity("Model1" , (short) 1));
        mockModelList.add(new MeterModelEntity("Model2", (short) 2));

        when(repository.findAll()).thenReturn(mockModelList);

        List<MeterModelEntity> result = controller.getModelEntityList();

        assertEquals(mockModelList, result);
        verify(repository).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testGetModelEntityListByLineName() {
        List<MeterModelEntity> mockModelList = new ArrayList<>();
        mockModelList.add(new MeterModelEntity("Model1" , (short) 1));
        mockModelList.add(new MeterModelEntity("Model2" , (short) 2));
        MeterCategoryEntity category = new MeterCategoryEntity("Category1" , (short) 1);

        when(service.getModelNameByCategoryName("Category1")).thenReturn(mockModelList);

        List<MeterModelEntity> result = controller.getModelEntity("Category1");

        assertEquals(mockModelList , result);
        verify(service).getModelNameByCategoryName("Category1");
        verifyNoMoreInteractions(service);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testPostModelEntity() {
        MeterModelEntity mockModel = new MeterModelEntity("Model1" , (short) 1);

        when(repository.save(mockModel)).thenReturn(mockModel);

        MeterModelEntity result = controller.postModelEntity(mockModel);

        assertEquals(mockModel , result);
        verify(repository).save(mockModel);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testDeleterCaategoryEntity() {
        MeterModelEntity mockModel = new MeterModelEntity("Model1" , (short) 1);

        when(repository.findByModelName("Model1")).thenReturn(mockModel);

        String result = controller.deleteModelEntity("Model1");

        assertEquals("Model deleted" , result);
        verify(repository).findByModelName("Model1");
        verify(repository).delete(mockModel);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testUpdateModelEntity() {
        MeterModelEntity mockModel = new MeterModelEntity("Model1" , (short) 1);

        when(repository.save(mockModel)).thenReturn(mockModel);

        String result = controller.updateModelEntity(mockModel);

        assertEquals("Model updated" , result);
        verify(repository).save(mockModel);
        verifyNoMoreInteractions(repository);
    }
}
