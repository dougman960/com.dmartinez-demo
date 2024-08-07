package com.dmartinez.service.impl;

import com.dmartinez.bussinessexception.BusinessException;
import com.dmartinez.dao.IPricesDao;
import com.dmartinez.models.dto.PricesDTO;
import com.dmartinez.models.entity.Prices;
import com.dmartinez.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Service
public class PriceServiceImpl implements IPriceService {

    private final IPricesDao iPricesDao;
    @Autowired
    public PriceServiceImpl(IPricesDao iPricesDao) {
        this.iPricesDao = iPricesDao;
    }

    @Transactional(readOnly = true)
    public PricesDTO findByBrandIdAndProductIdAndDate(String brandId, String productId, LocalDateTime date) {
        Prices prices = iPricesDao.findByBrandIdAndProductIdAndDate(brandId,productId,date);
        validarOffers(prices);
        return new PricesDTO(prices.getProductId(),prices.getBrandId(),prices.getPrice(),prices.getStartDate(),prices.getEndDate(),prices.getPrice());
    }

    private static void validarOffers(Prices prices) {
        if (ObjectUtils.isEmpty(prices)) {
            throw new BusinessException(HttpStatus.NOT_FOUND, "No active offers found");
        }
    }

}
