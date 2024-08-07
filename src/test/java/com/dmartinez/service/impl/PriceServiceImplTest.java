package com.dmartinez.service.impl;

import com.dmartinez.Datos;
import com.dmartinez.dao.IPricesDao;
import com.dmartinez.models.dto.PricesDTO;
import com.dmartinez.service.IPriceService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
class PriceServiceImplTest {

    @MockBean
    IPricesDao iPricesDao;

    @Autowired
    IPriceService iPriceService;


    @Test
    void findByBrandidAndProductidAndAndDateEx1(){

        when(iPricesDao.findByBrandIdAndProductIdAndDate("1","35455", LocalDateTime.of(2020,06,14,10,00,00))).thenReturn(Datos.prices1());

        PricesDTO pricesDTO = iPriceService.findByBrandIdAndProductIdAndDate("1","35455", LocalDateTime.of(2020,06,14,10,00,00));

        assertEquals("35.50",pricesDTO.getPrice().toPlainString());

    }

    @Test
    void findByBrandidAndProductidAndAndDateEx2(){

        when(iPricesDao.findByBrandIdAndProductIdAndDate("1","35455", LocalDateTime.of(2020,06,14,16,00,00))).thenReturn(Datos.prices2());

        PricesDTO pricesDTO = iPriceService.findByBrandIdAndProductIdAndDate("1","35455", LocalDateTime.of(2020,06,14,16,00,00));

        assertEquals("25.45",pricesDTO.getPrice().toPlainString());

    }


    @Test
    void findByBrandidAndProductidAndAndDateEx3(){

        when(iPricesDao.findByBrandIdAndProductIdAndDate("1","35455", LocalDateTime.of(2020,06,14,21,00,00))).thenReturn(Datos.prices1());

        PricesDTO pricesDTO = iPriceService.findByBrandIdAndProductIdAndDate("1","35455", LocalDateTime.of(2020,06,14,21,00,00));

        assertEquals("35.50",pricesDTO.getPrice().toPlainString());

    }


    @Test
    void findByBrandidAndProductidAndAndDateEx4(){

        when(iPricesDao.findByBrandIdAndProductIdAndDate("1","35455", LocalDateTime.of(2020,06,15,10,00,00))).thenReturn(Datos.prices3());

        PricesDTO pricesDTO = iPriceService.findByBrandIdAndProductIdAndDate("1","35455", LocalDateTime.of(2020,06,15,10,00,00));

        assertEquals("30.50",pricesDTO.getPrice().toPlainString());

    }


    @Test
    void findByBrandidAndProductidAndAndDateEx5(){

        when(iPricesDao.findByBrandIdAndProductIdAndDate("1","35455", LocalDateTime.of(2020,06,16,21,00,00))).thenReturn(Datos.prices4());

        PricesDTO pricesDTO = iPriceService.findByBrandIdAndProductIdAndDate("1","35455", LocalDateTime.of(2020,06,16,21,00,00));

        assertEquals("38.95",pricesDTO.getPrice().toPlainString());

    }


    @Test
    void findByBrandidAndProductidAndAndDateFailure(){

        when(iPricesDao.findByBrandIdAndProductIdAndDate("1","35455", LocalDateTime.of(2024,06,16,21,00,00))).thenReturn(null);

        assertThrows(RuntimeException.class, () -> {
            iPriceService.findByBrandIdAndProductIdAndDate("1","35455", LocalDateTime.of(2024,06,16,21,00,00));
        });

    }

    @Test
    void testFindByBrandIdAndProductIdAndDate_DataAccessException() {
        when(iPricesDao.findByBrandIdAndProductIdAndDate(anyString(), anyString(), any(LocalDateTime.class)))
                .thenThrow(new DataIntegrityViolationException("DB error"));
        assertThrows(DataAccessException.class, () -> {
            iPriceService.findByBrandIdAndProductIdAndDate("_","+", LocalDateTime.of(2024,06,16,21,00,00));
        });
    }

}