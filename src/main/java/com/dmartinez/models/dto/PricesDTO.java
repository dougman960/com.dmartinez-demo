package com.dmartinez.models.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PricesDTO implements Serializable {


    private String productId;
    private String BrandId;
    private BigDecimal price;

    @DateTimeFormat(iso =  DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startDate;

    @DateTimeFormat(iso =  DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endDate;

    private BigDecimal priceFinal;


    public PricesDTO() {
    }

    public PricesDTO(String productId, String brandId, BigDecimal price, LocalDateTime startDate, LocalDateTime endDate, BigDecimal priceFinal) {
        this.productId = productId;
        BrandId = brandId;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceFinal = priceFinal;
    }

    private static final long serialVersionUID = 1L;
}
