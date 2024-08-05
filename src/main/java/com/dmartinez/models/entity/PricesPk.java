package com.dmartinez.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;


@NoArgsConstructor
@Getter
public class PricesPk implements Serializable {

    private String brandId;
    private String priceList;
    private String productId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PricesPk pricesPk = (PricesPk) o;
        return Objects.equals(brandId, pricesPk.brandId) && Objects.equals(priceList, pricesPk.priceList) && Objects.equals(productId, pricesPk.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, priceList, productId);
    }

    private static final long serialVersionUID = 1L;
}
