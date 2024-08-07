package com.dmartinez.service;

import com.dmartinez.models.dto.PricesDTO;

import java.time.LocalDateTime;

public interface IPriceService {
    PricesDTO findByBrandIdAndProductIdAndDate(String brandId, String productId, LocalDateTime date);}
