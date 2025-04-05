package com.inditex.ecommerce.infrastructure.rest;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@AutoConfigureMockMvc
class PriceApiRestAssuredTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void test1_priceAt10AM14thJune() {
        given()
                .queryParam("date", "2020-06-14-10.00.00")
                .queryParam("productId", "35455")
                .queryParam("brandId", "1")
                .when()
                .get("/api/prices")
                .then()
                .statusCode(200)
                .body("price", equalTo(35.5f));
    }

    @Test
    void test2_priceAt16PM14thJune() {
        given()
                .queryParam("date", "2020-06-14-16.00.00")
                .queryParam("productId", "35455")
                .queryParam("brandId", "1")
                .when()
                .get("/api/prices")
                .then()
                .statusCode(200)
                .body("price", equalTo(25.45f));
    }

    @Test
    void test3_priceAt21PM14thJune() {
        given()
                .queryParam("date", "2020-06-14-21.00.00")
                .queryParam("productId", "35455")
                .queryParam("brandId", "1")
                .when()
                .get("/api/prices")
                .then()
                .statusCode(200)
                .body("price", equalTo(35.5f));
    }

    @Test
    void test4_priceAt10AM15thJune() {
        given()
                .queryParam("date", "2020-06-15-10.00.00")
                .queryParam("productId", "35455")
                .queryParam("brandId", "1")
                .when()
                .get("/api/prices")
                .then()
                .statusCode(200)
                .body("price", equalTo(30.5f));
    }

    @Test
    void test5_priceAt21PM16thJune() {
        given()
                .queryParam("date", "2020-06-16-21.00.00")
                .queryParam("productId", "35455")
                .queryParam("brandId", "1")
                .when()
                .get("/api/prices")
                .then()
                .statusCode(200)
                .body("price", equalTo(38.95f));
    }
}