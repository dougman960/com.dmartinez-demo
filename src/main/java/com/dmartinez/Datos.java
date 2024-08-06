package com.dmartinez;

import com.dmartinez.models.entity.Currency;
import com.dmartinez.models.entity.Prices;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@UtilityClass
public class Datos {


    public static final String PRODUCT_ID = "35455";

    public static Prices prices1(){
        return new Prices("1", LocalDateTime.of(2020,06,14,00,00,00),LocalDateTime.of(2020,12,31,23,59,59),"1", PRODUCT_ID,0, new BigDecimal("35.50"), Currency.EUR);
    }


    public static Prices prices2(){
        return new Prices("1", LocalDateTime.of(2020,06,14,15,00,00),LocalDateTime.of(2020,06,14,18,30,00),"1",PRODUCT_ID,1, new BigDecimal("25.45"), Currency.EUR);
    }

    public static Prices prices3(){
        return new Prices("1", LocalDateTime.of(2020,06,15,00,00,00),LocalDateTime.of(2020,06,15,11,00,00),"1",PRODUCT_ID,1, new BigDecimal("30.50"), Currency.EUR);
    }

    public static Prices prices4(){
        return new Prices("1", LocalDateTime.of(2020,06,15,16,00,00),LocalDateTime.of(2020,12,31,23,59,59),"1",PRODUCT_ID,1, new BigDecimal("38.95"), Currency.EUR);
    }
}
