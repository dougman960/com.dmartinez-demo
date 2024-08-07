package com.dmartinez.controller;


import com.dmartinez.models.dto.BasicResponseDTO;
import com.dmartinez.service.impl.PriceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerDbException {

    @Autowired
    private WebTestClient client;

    @MockBean
    private PriceServiceImpl priceServiceImpl;

    @BeforeEach
    void setUp() {
        when(priceServiceImpl.findByBrandIdAndProductIdAndDate(anyString(), anyString(), any(LocalDateTime.class)))
                .thenThrow(new DataIntegrityViolationException("DB error"));
    }

    @Test
    void testFindOffers_DataAccessException() throws Exception{
        client.get().uri("/service/proof?date=2020-06-16T21:00:00&productId=:&shop=_").exchange()
                .expectStatus().is5xxServerError()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(BasicResponseDTO.class)
                .consumeWith(response ->{
                    BasicResponseDTO basicResponseDTO = response.getResponseBody();
                    assertEquals("Error when making requests to the database",basicResponseDTO.getResponse());
                });
    }

}
