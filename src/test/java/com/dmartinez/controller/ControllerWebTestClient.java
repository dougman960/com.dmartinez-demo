package com.dmartinez.controller;

import com.dmartinez.models.dto.BasicResponseDTO;
import com.dmartinez.models.dto.PricesDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;

import static  org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerWebTestClient {

    @Autowired
    private WebTestClient client;


    @Test
    void testFindOffersEx1(){
        client.get().uri("/service/proof?date=2020-06-14T10:00:00&productId=35455&shop=1").exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(PricesDTO.class)
                .consumeWith(response ->{
                    PricesDTO pricesDTO = response.getResponseBody();
                    assertEquals("35.50",pricesDTO.getPrice().toPlainString());
                    assertEquals(LocalDateTime.of(2020,06,14,00,00,00), pricesDTO.getStartDate());
                    assertEquals(LocalDateTime.of(2020,12,31,23,59,59), pricesDTO.getEndDate());
                });
    }

    @Test
    void testFindOffersEx2(){
        client.get().uri("/service/proof?date=2020-06-14T16:00:00&productId=35455&shop=1").exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(PricesDTO.class)
                .consumeWith(response ->{
                    PricesDTO pricesDTO = response.getResponseBody();
                    assertEquals("25.45",pricesDTO.getPrice().toPlainString());
                    assertEquals(LocalDateTime.of(2020,06,14,15,00,00), pricesDTO.getStartDate());
                    assertEquals(LocalDateTime.of(2020,06,14,18,30,00), pricesDTO.getEndDate());
                });
    }

    @Test
    void testFindOffersEx3(){
        client.get().uri("/service/proof?date=2020-06-14T21:00:00&productId=35455&shop=1").exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(PricesDTO.class)
                .consumeWith(response ->{
                    PricesDTO pricesDTO = response.getResponseBody();
                    assertEquals("35.50",pricesDTO.getPrice().toPlainString());
                    assertEquals(LocalDateTime.of(2020,06,14,00,00,00), pricesDTO.getStartDate());
                    assertEquals(LocalDateTime.of(2020,12,31,23,59,59), pricesDTO.getEndDate());
                });
    }

    @Test
    void testFindOffersEx4(){
        client.get().uri("/service/proof?date=2020-06-15T10:00:00&productId=35455&shop=1").exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(PricesDTO.class)
                .consumeWith(response ->{
                    PricesDTO pricesDTO = response.getResponseBody();
                    assertEquals("30.50",pricesDTO.getPrice().toPlainString());
                    assertEquals(LocalDateTime.of(2020,06,15,00,00,00), pricesDTO.getStartDate());
                    assertEquals(LocalDateTime.of(2020,06,15,11,00,00), pricesDTO.getEndDate());
                });
    }

    @Test
    void testFindOffersEx5(){
        client.get().uri("/service/proof?date=2020-06-16T21:00:00&productId=35455&shop=1").exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(PricesDTO.class)
                .consumeWith(response ->{
                    PricesDTO pricesDTO = response.getResponseBody();
                    assertEquals("38.95",pricesDTO.getPrice().toPlainString());
                    assertEquals(LocalDateTime.of(2020,06,15,16,00,00), pricesDTO.getStartDate());
                    assertEquals(LocalDateTime.of(2020,12,31,23,59,59), pricesDTO.getEndDate());
                });
    }

    @Test
    void testFindOffersFailure(){
        client.get().uri("/service/proof?date=2024-06-15T10:00:00&productId=35455&shop=1").exchange()
                .expectStatus().isNotFound()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(BasicResponseDTO.class)
                .consumeWith(response ->{
                    BasicResponseDTO basicResponseDTO = response.getResponseBody();
                    assertEquals("No active offers found", basicResponseDTO.getResponse());
                });
    }


}