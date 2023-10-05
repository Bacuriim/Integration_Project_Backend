package com.br.eletra.services;


import com.br.eletra.models.MeterLineEntity;
import com.br.eletra.repository.LineRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MeterLineServiceTest {

		@InjectMocks
		MeterLineService service;

		@Mock
		private LineRepo lineRepo;

		public MeterLineEntity line;

		@BeforeEach
		public void setUp() {
			line = new MeterLineEntity("Cronos" , (short) 0);
		}

		@Test
		public void searchMeterLineByLineName() {
				when(lineRepo.findByLineName(line.getLineName())).thenReturn(line);

				Short result = service.getLineIdByLineName(line.getLineName());

				assertEquals(line.getId() , result);
				verify(lineRepo).findByLineName(line.getLineName());
				verifyNoMoreInteractions(lineRepo);
		}
}
