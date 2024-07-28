package com.dmartinez.service.impl;

import com.dmartinez.Datos;
import com.dmartinez.dao.IPriceDao;
import com.dmartinez.models.dto.PricesDTO;
import com.dmartinez.models.entity.Prices;
import com.dmartinez.service.IPriceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

        List<Prices> pricesList = new ArrayList<>();
        pricesList.add(Datos.prices1());

        when(iPriceDao.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,14,10,00,00))).thenReturn(pricesList);

        PricesDTO pricesDTO = iPriceService.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,14,10,00,00));

        assertEquals("35.50",pricesDTO.getPrice().toPlainString());

    }

    @Test
    void findByBrandidAndProductidAndAndDateEx2(){

        List<Prices> pricesList = new ArrayList<>();
        pricesList.add(Datos.prices1());
        pricesList.add(Datos.prices2());

        when(iPriceDao.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,14,16,00,00))).thenReturn(pricesList);

        PricesDTO pricesDTO = iPriceService.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,14,16,00,00));

        assertEquals("25.45",pricesDTO.getPrice().toPlainString());

    }


    @Test
    void findByBrandidAndProductidAndAndDateEx3(){

        List<Prices> pricesList = new ArrayList<>();
        pricesList.add(Datos.prices1());

        when(iPriceDao.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,14,21,00,00))).thenReturn(pricesList);

        PricesDTO pricesDTO = iPriceService.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,14,21,00,00));

        assertEquals("35.50",pricesDTO.getPrice().toPlainString());

    }


    @Test
    void findByBrandidAndProductidAndAndDateEx4(){

        List<Prices> pricesList = new ArrayList<>();
        pricesList.add(Datos.prices1());
        pricesList.add(Datos.prices3());

        when(iPriceDao.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,15,10,00,00))).thenReturn(pricesList);

        PricesDTO pricesDTO = iPriceService.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,15,10,00,00));

        assertEquals("30.50",pricesDTO.getPrice().toPlainString());

    }


    @Test
    void findByBrandidAndProductidAndAndDateEx5(){

        List<Prices> pricesList = new ArrayList<>();
        pricesList.add(Datos.prices1());
        pricesList.add(Datos.prices4());

        when(iPriceDao.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,16,21,00,00))).thenReturn(pricesList);

        PricesDTO pricesDTO = iPriceService.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2020,06,16,21,00,00));

        assertEquals("38.95",pricesDTO.getPrice().toPlainString());

    }


    @Test
    void findByBrandidAndProductidAndAndDateFailure(){

        List<Prices> pricesList = new ArrayList<>();


        when(iPriceDao.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2024,06,16,21,00,00))).thenReturn(pricesList);

        assertThrows(RuntimeException.class, () -> {
            iPriceService.findByBrandidAndProductidAndAndDate("1","35455", LocalDateTime.of(2024,06,16,21,00,00));
        });

    }

}