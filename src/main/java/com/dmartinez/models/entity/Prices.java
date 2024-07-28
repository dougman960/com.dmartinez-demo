package com.dmartinez.models.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="prices")
@IdClass(Prices_PK.class)
public class Prices implements Serializable {


    @Id
    @Column(name="brand_id")
    private String brandid;

    @Column(name="start_date")
    private LocalDateTime startdate;

    @Column(name="end_date")
    private LocalDateTime enddate;

    @Id
    private String price_list;

    @Id
    private String product_id;
    private Integer priority;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Currency curr;

    public Prices() {
    }

    public Prices(String brandid, LocalDateTime startdate, LocalDateTime enddate, String price_list, String product_id, Integer priority, BigDecimal price, Currency curr) {
        this.brandid = brandid;
        this.startdate = startdate;
        this.enddate = enddate;
        this.price_list = price_list;
        this.product_id = product_id;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

    private static final long serialVersionUID = 1L;
}
