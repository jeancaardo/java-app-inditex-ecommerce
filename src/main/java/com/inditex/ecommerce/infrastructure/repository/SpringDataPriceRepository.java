package com.inditex.ecommerce.infrastructure.repository;

import com.inditex.ecommerce.infrastructure.repository.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SpringDataPriceRepository extends JpaRepository<PriceEntity, Long> {
    Optional<PriceEntity> findTopByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
        Long productId, Long brandId, LocalDateTime dateStart, LocalDateTime dateEnd
    );
}