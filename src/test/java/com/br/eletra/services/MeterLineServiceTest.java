package com.br.eletra.services;


import com.br.eletra.models.MeterLineEntity;
import com.br.eletra.repository.LineRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MeterLineServiceTest {

		@InjectMocks
		private MeterLineService service;

		@Mock
		private LineRepo lineRepo;


		@BeforeEach
		public void setUp() {
			MockitoAnnotations.initMocks(this);
		}

		@Test
		public void searchMeterLineByLineNameTest() {
			MeterLineEntity mockLine = new MeterLineEntity("Ares" , (short) 1);
			when(lineRepo.findByLineName(mockLine.getLineName())).thenReturn(mockLine);

			Short result = service.getLineIdByLineName(mockLine.getLineName());

			assertEquals(mockLine.getId() , result);
			verify(lineRepo).findByLineName(mockLine.getLineName());
			verifyNoMoreInteractions(lineRepo);
		}
}
