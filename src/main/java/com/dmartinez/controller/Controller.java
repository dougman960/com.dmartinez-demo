package com.dmartinez.controller;


import com.dmartinez.models.dto.BasicResponseDTO;
import com.dmartinez.models.dto.PricesDTO;
import com.dmartinez.service.impl.PriceServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/service/proof")
public class Controller {

    private final PriceServiceImpl priceServiceImpl;

    @Autowired
    public Controller(PriceServiceImpl priceServiceImpl) {
        this.priceServiceImpl = priceServiceImpl;
    }


    @ApiOperation(value = "Search offers by stores")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = PricesDTO.class),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = BasicResponseDTO.class),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = BasicResponseDTO.class) })
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<PricesDTO> findOffers (@RequestParam(name = "date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                                                 @RequestParam(name = "productId", required = true) String productId,
                                                 @RequestParam(name = "shop", required = true) String shop){
        PricesDTO pricesDTO = priceServiceImpl.findByBrandIdAndProductIdAndDate(shop, productId, date);
        return new ResponseEntity<>(pricesDTO, HttpStatus.OK);
    }
}
