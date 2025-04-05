package com.inditex.ecommerce.infrastructure.repository;

import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.domain.port.PriceRepository;
import com.inditex.ecommerce.infrastructure.repository.entity.PriceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PriceRepositoryAdapter implements PriceRepository {

    private final SpringDataPriceRepository jpa;

    @Override
    public Optional<Price> findApplicablePrice(java.time.LocalDateTime date, Long productId, Long brandId) {
        return jpa.findTopByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            productId, brandId, date, date
        ).map(this::toDomain);
    }

    private Price toDomain(PriceEntity e) {
        return new Price(
            e.getBrandId(), e.getStartDate(), e.getEndDate(),
            e.getPriceList(), e.getProductId(), e.getPriority(),
            e.getPrice(), e.getCurr()
        );
    }
}