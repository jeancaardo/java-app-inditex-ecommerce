package com.inditex.ecommerce.application.price.impl;

import com.inditex.ecommerce.application.price.PriceUseCase;
import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.domain.port.PriceRepository;
import com.inditex.ecommerce.infrastructure.exception.PriceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceService implements PriceUseCase {

    private final PriceRepository repository;

    @Override
    public Price getPrice(LocalDateTime date, Long productId, Long brandId) {
        return repository.findApplicablePrice(date, productId, brandId)
                .orElseThrow(() -> new PriceNotFoundException("No price found for provided parameters"));
    }
}