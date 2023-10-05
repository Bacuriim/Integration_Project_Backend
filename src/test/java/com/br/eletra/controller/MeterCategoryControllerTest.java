package com.br.eletra.controller;

import com.br.eletra.models.MeterCategoryEntity;
import com.br.eletra.models.MeterLineEntity;
import com.br.eletra.repository.CategoryRepo;
import com.br.eletra.services.MeterCategoryService;
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
public class MeterCategoryControllerTest {

    @InjectMocks
    MeterCategoryController controller;

    @Mock
    private CategoryRepo repository;

    @Mock
    private MeterCategoryService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getCategoryEntityListTest() {
        List<MeterCategoryEntity> mockCategoryList = new ArrayList<>();
        mockCategoryList.add(new MeterCategoryEntity("Category1" , (short) 1));
        mockCategoryList.add(new MeterCategoryEntity("Category2", (short) 2));

        when(repository.findAll()).thenReturn(mockCategoryList);

        List<MeterCategoryEntity> result = controller.getCategoryEntityList();

        assertEquals(mockCategoryList, result);
        verify(repository).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void getCategoryEntityListByLineNameTest() {
        List<MeterCategoryEntity> mockCategoryList = new ArrayList<>();
        mockCategoryList.add(new MeterCategoryEntity("Category1" , (short) 1));
        mockCategoryList.add(new MeterCategoryEntity("Category2" , (short) 2));
        MeterLineEntity line = new MeterLineEntity("Line" , (short) 1);

        when(service.getCategoriesByLineName("Line")).thenReturn(mockCategoryList);

        List<MeterCategoryEntity> result = controller.getCategoriesByLine("Line");

        assertEquals(mockCategoryList , result);
        verify(service).getCategoriesByLineName("Line");
        verifyNoMoreInteractions(service);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void postCategoryEntityTest() {
        MeterCategoryEntity mockCategory = new MeterCategoryEntity("Category1" , (short) 1);

        when(repository.save(mockCategory)).thenReturn(mockCategory);

        MeterCategoryEntity result = controller.postCategoryEntity(mockCategory);

        assertEquals(mockCategory , result);
        verify(repository).save(mockCategory);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void deleteCategoryEntityTest() {
        MeterCategoryEntity mockCategory = new MeterCategoryEntity("Category1" , (short) 1);

        when(repository.findByCategoryName("Category1")).thenReturn(mockCategory);

        String result = controller.deleteCategoryEntity("Category1");

        assertEquals("Category deleted" , result);
        verify(repository).findByCategoryName("Category1");
        verify(repository).delete(mockCategory);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void updateCategoryEntityTest() {
        MeterCategoryEntity mockCategory = new MeterCategoryEntity("Category1" , (short) 1);

        when(repository.save(mockCategory)).thenReturn(mockCategory);

        String result = controller.updateCategoryEntity(mockCategory);

        assertEquals("Category updated" , result);
        verify(repository).save(mockCategory);
        verifyNoMoreInteractions(repository);
    }
}
