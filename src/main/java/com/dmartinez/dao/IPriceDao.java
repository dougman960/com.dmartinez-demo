package com.dmartinez.dao;

import com.dmartinez.models.dto.PricesDTO;
import com.dmartinez.models.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IPriceDao extends JpaRepository<Prices,String> {


    @Query(value="SELECT P.*" +
            "             FROM Prices P" +
            "             WHERE " +
            "             P.BRAND_ID = :brandId  and " +
            "             P.PRODUCT_ID = :productId and " +
            "            ( :date BETWEEN P.staRT_DATE   AND P.end_DATE )  and" +
            "            P.PRIORITY  =  (SELECT max(C.PRIORITY)" +
            "             FROM Prices C" +
            "             WHERE " +
            "             C.BRAND_ID = :brandId and " +
            "             C.PRODUCT_ID = :productId and " +
            "            ( :date BETWEEN C.staRT_DATE   AND C.end_DATE ));",nativeQuery = true)
    Prices findByBrandidAndProductidAndAndDate(@Param("brandId") String brandId, @Param("productId") String productId, @Param("date") LocalDateTime date);
}
