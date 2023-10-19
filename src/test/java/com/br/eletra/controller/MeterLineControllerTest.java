package com.br.eletra.controller;

import com.br.eletra.models.MeterLineEntity;
import com.br.eletra.repository.LineRepo;
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
public class MeterLineControllerTest {

    @InjectMocks
    MeterLineController controller;

    @Mock
    private LineRepo repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getLineEntityListTest() {
        List<MeterLineEntity> mockLineList = new ArrayList<>();
        mockLineList.add(new MeterLineEntity("Line1", (short) 1));
        mockLineList.add(new MeterLineEntity("Line2", (short) 2));

        when(repository.findAll()).thenReturn(mockLineList);

        List<MeterLineEntity> result = controller.getLineEntityList();

        assertEquals(mockLineList, result);
        verify(repository).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void getLineEntityTest() {
        MeterLineEntity mockLine = new MeterLineEntity("Line1", (short) 1);

        when(repository.findByLineName("Line1")).thenReturn(mockLine);

        MeterLineEntity result = controller.getLineEntity("Line1");

        assertEquals(mockLine, result);
        verify(repository).findByLineName("Line1");
        verifyNoMoreInteractions(repository);
    }

    @Test
    void postLineEntityTest() {
        MeterLineEntity mockLine = new MeterLineEntity("line1" , (short) 1);

        when(repository.save(mockLine)).thenReturn(mockLine);

        MeterLineEntity result = controller.postLineEntity(mockLine);

        assertEquals(mockLine , result);
        verify(repository).save(mockLine);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void deleteLineEntityTest() {
        MeterLineEntity mockLine = new MeterLineEntity("Line1" , (short) 1);

        when(repository.findByLineName("Line1")).thenReturn(mockLine);

        String result = controller.deleteLineEntity("Line1");

        assertEquals("Line deleted" , result);
        verify(repository).findByLineName("Line1");
        verify(repository).delete(mockLine);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void putLineEntityTest() {
        MeterLineEntity mockLine = new MeterLineEntity("Line1" , (short) 1);

        when(repository.save(mockLine)).thenReturn(mockLine);

        String result = controller.updateLineEntity(mockLine);

        assertEquals("Line updated" , result);
        verify(repository).save(mockLine);
        verifyNoMoreInteractions(repository);
    }

}
