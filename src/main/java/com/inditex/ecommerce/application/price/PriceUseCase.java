package com.inditex.ecommerce.application.price;

import com.inditex.ecommerce.domain.model.Price;

import java.time.LocalDateTime;

public interface PriceUseCase {
    Price getPrice(LocalDateTime date, Long productId, Long brandId);
}
