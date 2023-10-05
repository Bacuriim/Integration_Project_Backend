package com.br.eletra.services;

import com.br.eletra.models.MeterCategoryEntity;
import com.br.eletra.models.MeterLineEntity;
import com.br.eletra.repository.CategoryRepo;
import org.junit.jupiter.api.BeforeEach;
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
public class MeterCategoryServiceTest {

		@InjectMocks
		MeterCategoryService categoryService;

		@Mock
		private CategoryRepo categoryRepo;

		MeterLineEntity line2;

		MeterCategoryEntity category;

		@BeforeEach
		public void setUp() {
			line2 = new MeterLineEntity("Cronos" , (short) 1);

			category = new MeterCategoryEntity("Ares TB" , (short) 1);

		}

		@Test
		public void searchCategoriesByMeterLineName() {
				when(categoryRepo.findByLineId(line2.getId())).thenReturn(Collections.singletonList(category));

				List<MeterCategoryEntity> result = categoryService.getCategoriesByLineName(line2.getLineName());

				assertEquals(Collections.singletonList(category), result);
				verify(categoryRepo).findByLineId(line2.getId());
				verifyNoMoreInteractions(categoryRepo);
		}

		@Test
		public void searchCategoryIdByCategoryName() {
				when(categoryRepo.findByCategoryName(category.getCategoryName())).thenReturn(category);

				Short result = categoryService.getCategoryIdByCategoryName(category.getCategoryName());

				assertEquals(category.getId() , result);
				verify(categoryRepo).findByCategoryName(category.getCategoryName());
				verifyNoMoreInteractions(categoryRepo);
		}



}
