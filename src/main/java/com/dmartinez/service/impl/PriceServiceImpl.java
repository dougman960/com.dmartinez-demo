package com.dmartinez.service.impl;

import com.dmartinez.bussinessexception.BasixException;
import com.dmartinez.dao.IPriceDao;
import com.dmartinez.models.dto.PricesDTO;
import com.dmartinez.models.entity.Prices;
import com.dmartinez.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Service
public class PriceServiceImpl implements IPriceService {

    private final IPriceDao iPriceDao;

    @Autowired
    public PriceServiceImpl(IPriceDao iPriceDao) {
        this.iPriceDao = iPriceDao;
    }


    @Transactional(readOnly = true)
    public PricesDTO findByBrandidAndProductidAndAndDate(String brandId, String productId, LocalDateTime date) {

        Prices prices = iPriceDao.findByBrandidAndProductidAndAndDate(brandId,productId,date);

        if(ObjectUtils.isEmpty(prices)){
            throw new BasixException("No active offers found");
        }

        return new PricesDTO(prices.getProductId(),prices.getBrandId(),prices.getPrice(),prices.getStartDate(),prices.getEndDate(),prices.getPrice());
    }
}
