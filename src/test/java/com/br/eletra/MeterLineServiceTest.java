package com.br.eletra;


import com.br.eletra.models.MeterLineEntity;
import com.br.eletra.repository.LineRepo;
import com.br.eletra.services.MeterLineService;
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
		LineRepo lineRepo;

		MeterLineEntity line = new MeterLineEntity("Ares" , (short) 1);

		@Test
		public void searchMeterLineByLineName() {
				when(lineRepo.findByLineName(line.getLineName())).thenReturn(line);

				Short result = service.getLineIdByLineName(line.getLineName());

				assertEquals(line.getId() , result);
				verify(lineRepo).findByLineName(line.getLineName());
				verifyNoMoreInteractions(lineRepo);
		}
}
