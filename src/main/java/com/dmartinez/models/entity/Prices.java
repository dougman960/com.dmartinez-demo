package com.dmartinez.models.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="prices")
@IdClass(PricesPk.class)
public class Prices implements Serializable {

    @Id
    @Column(name="brand_id")
    private String brandId;
    @Column(name="start_date")
    private LocalDateTime startDate;
    @Column(name="end_date")
    private LocalDateTime endDate;
    @Id
    @Column(name="price_list")
    private String priceList;
    @Id
    @Column(name="product_id")
    private String productId;
    private Integer priority;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Currency curr;

    public Prices() {
    }

    public Prices(String brandId, LocalDateTime startDate, LocalDateTime endDate, String priceList, String productId, Integer priority, BigDecimal price, Currency curr) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

    private static final long serialVersionUID = 1L;
}
