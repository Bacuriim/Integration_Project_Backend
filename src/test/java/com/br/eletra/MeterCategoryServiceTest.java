package com.br.eletra;

import com.br.eletra.models.MeterCategoryEntity;
import com.br.eletra.models.MeterLineEntity;
import com.br.eletra.repository.CategoryRepo;
import com.br.eletra.repository.LineRepo;
import com.br.eletra.services.MeterCategoryService;
import com.br.eletra.services.MeterLineService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MeterCategoryServiceTest {

		@InjectMocks
		private MeterCategoryService categoryService;

		@Mock
		private MeterLineService lineService;

		@Mock
		private CategoryRepo categoryRepo;

		@Mock
		private LineRepo lineRepo;

		MeterLineEntity line = new MeterLineEntity("Ares" , (short) 0);
		MeterCategoryEntity category = new MeterCategoryEntity("Ares TB" , (short) 1);

		@Test
		public void searchCategoriesByMeterLineName() {
				when(categoryRepo.findByLineId(line.getId())).thenReturn(Collections.singletonList(category));

				List<MeterCategoryEntity> result = categoryService.getCategoriesByLineName(line.getLineName());

				assertEquals(Collections.singletonList(category), result);
				verify(categoryRepo).findByLineId(line.getId());
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
