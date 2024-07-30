package com.dmartinez.service.impl;

import com.dmartinez.Datos;
import com.dmartinez.dao.IPriceDao;
import com.dmartinez.models.dto.PricesDTO;
import com.dmartinez.models.entity.Prices;
import com.dmartinez.service.IPriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
class PriceServiceImplTest {

    @MockBean
    IPriceDao iPriceDao;

    @Autowired
    IPriceService iPriceService;


    @Test
    void findByBrandidAndProductidAndAndDateEx1(){

        when(iPriceDao.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,14,10,00,00))).thenReturn(Datos.prices1());

        PricesDTO pricesDTO = iPriceService.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,14,10,00,00));

        assertEquals("35.50",pricesDTO.getPrice().toPlainString());

    }

    @Test
    void findByBrandidAndProductidAndAndDateEx2(){

        when(iPriceDao.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,14,16,00,00))).thenReturn(Datos.prices2());

        PricesDTO pricesDTO = iPriceService.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,14,16,00,00));

        assertEquals("25.45",pricesDTO.getPrice().toPlainString());

    }


    @Test
    void findByBrandidAndProductidAndAndDateEx3(){

        when(iPriceDao.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,14,21,00,00))).thenReturn(Datos.prices1());

        PricesDTO pricesDTO = iPriceService.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,14,21,00,00));

        assertEquals("35.50",pricesDTO.getPrice().toPlainString());

    }


    @Test
    void findByBrandidAndProductidAndAndDateEx4(){

        when(iPriceDao.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,15,10,00,00))).thenReturn(Datos.prices3());

        PricesDTO pricesDTO = iPriceService.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,15,10,00,00));

        assertEquals("30.50",pricesDTO.getPrice().toPlainString());

    }


    @Test
    void findByBrandidAndProductidAndAndDateEx5(){

        when(iPriceDao.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,16,21,00,00))).thenReturn(Datos.prices4());

        PricesDTO pricesDTO = iPriceService.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,16,21,00,00));

        assertEquals("38.95",pricesDTO.getPrice().toPlainString());

    }


    @Test
    void findByBrandidAndProductidAndAndDateFailure(){

        when(iPriceDao.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2024,06,16,21,00,00))).thenReturn(null);

        assertThrows(RuntimeException.class, () -> {
            iPriceService.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2024,06,16,21,00,00));
        });

    }

}