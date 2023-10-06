package com.br.eletra.services;

import com.br.eletra.models.MeterCategoryEntity;
import com.br.eletra.models.MeterLineEntity;
import com.br.eletra.repository.CategoryRepo;
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
public class MeterCategoryServiceTest {

	@InjectMocks
	private MeterCategoryService categoryService;

	@Mock
	private CategoryRepo categoryRepo;

	@Mock
	private MeterLineService meterLineService;


	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void searchCategoriesByMeterLineNameTest() {
		MeterLineEntity mockLine = new MeterLineEntity("Line1" , (short) 1);
		MeterCategoryEntity mockCategory = new MeterCategoryEntity("AresTB" , (short) 1);
		when(categoryRepo.findByLineId(mockLine.getId())).thenReturn(Collections.singletonList(mockCategory));
		when(meterLineService.getLineIdByLineName(mockLine.getLineName())).thenReturn(mockLine.getId());

		List<MeterCategoryEntity> result = categoryService.getCategoriesByLineName(mockLine.getLineName());

		assertEquals(Collections.singletonList(mockCategory), result);
		verify(categoryRepo).findByLineId(mockLine.getId());
		verifyNoMoreInteractions(categoryRepo);
	}

	@Test
	public void searchCategoryIdByCategoryNameTest() {
		MeterCategoryEntity mockCategory = new MeterCategoryEntity("AresTB" , (short) 1);
		when(categoryRepo.findByCategoryName(mockCategory.getCategoryName())).thenReturn(mockCategory);

		Short result = categoryService.getCategoryIdByCategoryName(mockCategory.getCategoryName());

		assertEquals(mockCategory.getId() , result);
		verify(categoryRepo).findByCategoryName(mockCategory.getCategoryName());
		verifyNoMoreInteractions(categoryRepo);
	}
}
