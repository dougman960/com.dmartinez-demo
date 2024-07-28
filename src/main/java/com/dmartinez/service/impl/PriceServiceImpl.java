package com.dmartinez.service.impl;

import com.dmartinez.bussinessexception.BasixException;
import com.dmartinez.dao.IPriceDao;
import com.dmartinez.models.dto.PricesDTO;
import com.dmartinez.models.entity.Prices;
import com.dmartinez.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceServiceImpl implements IPriceService {


    private final IPriceDao iPriceDao;

    @Autowired
    public PriceServiceImpl(IPriceDao iPriceDao) {
        this.iPriceDao = iPriceDao;
    }


    @Transactional(readOnly = true)
    public PricesDTO findByBrandidAndProductidAndAndDate(String brandId, String productId, LocalDateTime date) {

        List<Prices> list_prices = iPriceDao.findByBrandidAndProductidAndAndDate(brandId,productId,date);

        if(list_prices.isEmpty()){
            throw new BasixException("No active offers found");
        }
        Prices prices = list_prices.stream().max(Comparator.comparing(Prices::getPriority)).get();

        return new PricesDTO(prices.getProduct_id(),prices.getBrandid(),prices.getPrice(),prices.getStartdate(),prices.getEnddate(),prices.getPrice());
    }
}
