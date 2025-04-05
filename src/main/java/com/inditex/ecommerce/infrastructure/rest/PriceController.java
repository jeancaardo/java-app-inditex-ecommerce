package com.inditex.ecommerce.infrastructure.rest;

import com.inditex.ecommerce.application.price.impl.PriceService;
import com.inditex.ecommerce.domain.model.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService service;

    @GetMapping
    public ResponseEntity<PriceResponse> getPrice(
        @RequestParam String date,
        @RequestParam Long productId,
        @RequestParam Long brandId
    ) {
        LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"));
        Price price = service.getPrice(dateTime, productId, brandId);
        return ResponseEntity.ok(PriceResponse.from(price));
    }
}