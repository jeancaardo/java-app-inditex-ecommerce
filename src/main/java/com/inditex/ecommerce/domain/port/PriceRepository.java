package com.inditex.ecommerce.domain.port;

import com.inditex.ecommerce.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {
    Optional<Price> findApplicablePrice(LocalDateTime date, Long productId, Long brandId);
}