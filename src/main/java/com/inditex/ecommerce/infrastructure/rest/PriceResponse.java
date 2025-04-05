package com.inditex.ecommerce.infrastructure.rest;

import com.inditex.ecommerce.domain.model.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceResponse(
    Long productId,
    Long brandId,
    Integer priceList,
    LocalDateTime startDate,
    LocalDateTime endDate,
    BigDecimal price
) {
    public static PriceResponse from(Price p) {
        return new PriceResponse(p.productId(), p.brandId(), p.priceList(), p.startDate(), p.endDate(), p.price());
    }
}