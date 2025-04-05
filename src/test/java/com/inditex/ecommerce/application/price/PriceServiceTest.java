package com.inditex.ecommerce.application.price;

import com.inditex.ecommerce.application.price.impl.PriceService;
import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.domain.port.PriceRepository;
import com.inditex.ecommerce.infrastructure.exception.PriceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PriceServiceTest {

    private PriceRepository repository;
    private PriceService service;

    @BeforeEach
    void setup() {
        repository = mock(PriceRepository.class);
        service = new PriceService(repository);
    }

    @Test
    void shouldReturnPriceWhenExists() {
        // Given
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        Price expectedPrice = new Price(
                brandId, date, date.plusHours(1), 1, productId, 1, new BigDecimal("35.50"), "EUR"
        );

        when(repository.findApplicablePrice(date, productId, brandId)).thenReturn(Optional.of(expectedPrice));

        // When
        Price result = service.getPrice(date, productId, brandId);

        // Then
        assertEquals(expectedPrice, result);
        verify(repository).findApplicablePrice(date, productId, brandId);
    }

    @Test
    void shouldThrowExceptionWhenPriceNotFound() {
        // Given
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0);
        Long productId = 999L;
        Long brandId = 1L;

        when(repository.findApplicablePrice(date, productId, brandId)).thenReturn(Optional.empty());

        // When / Then
        assertThrows(PriceNotFoundException.class, () -> {
            service.getPrice(date, productId, brandId);
        });

        verify(repository).findApplicablePrice(date, productId, brandId);
    }
}