package com.dmartinez.service;

import com.dmartinez.models.dto.PricesDTO;
import com.dmartinez.models.entity.Prices;

import java.time.LocalDateTime;
import java.util.List;

public interface IPriceService {
    PricesDTO findByBrandidAndProductidAndAndDate(String brandId, String productId, LocalDateTime date);}
