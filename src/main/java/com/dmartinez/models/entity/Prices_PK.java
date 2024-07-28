package com.dmartinez.models.entity;

import java.io.Serializable;
public class Prices_PK implements Serializable {

    private String brandid;
    private String price_list;
    private String product_id;

    public Prices_PK() {
    }

    public Prices_PK(String brandid, String price_list, String product_id) {
        this.brandid = brandid;
        this.price_list = price_list;
        this.product_id = product_id;
    }

    private static final long serialVersionUID = 1L;
}
