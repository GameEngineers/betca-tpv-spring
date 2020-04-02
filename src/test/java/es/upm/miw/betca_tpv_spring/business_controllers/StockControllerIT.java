package es.upm.miw.betca_tpv_spring.business_controllers;

import es.upm.miw.betca_tpv_spring.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

import java.util.HashMap;


@TestConfig
class StockControllerIT {
    @Autowired
    private StockController stockController;

    @Test
    void testReadAll() {
        StepVerifier
                .create(this.stockController.readAll())
                .expectNextCount(10)
                .expectComplete()
                .verify();
    }

    @Test
    void testArticleInfo() {
        StepVerifier
                .create(this.stockController.getArticleInfo())
                .expectNextCount(10)
                .expectComplete()
                .verify();
    }

    @Test
    void testGetSoldUnits() {
        HashMap<String, Integer> unitsMap = new HashMap<>();
        unitsMap.put("8400000000017", 2);
        unitsMap.put("8400000000031", 12);
        unitsMap.put("8400000000055", 12);
        unitsMap.put("8400000000024", 3);
        StepVerifier
                .create(this.stockController.getSoldUnits())
                .expectNextMatches(articleStockDto -> articleStockDto.getSoldUnits().equals(unitsMap.get(articleStockDto.getCode())))
                .expectNextMatches(articleStockDto -> articleStockDto.getSoldUnits().equals(unitsMap.get(articleStockDto.getCode())))
                .expectNextMatches(articleStockDto -> articleStockDto.getSoldUnits().equals(unitsMap.get(articleStockDto.getCode())))
                .expectNextMatches(articleStockDto -> articleStockDto.getSoldUnits().equals(unitsMap.get(articleStockDto.getCode())))
                .expectComplete()
                .verify();
    }

    @Test
    void testGetShopping() {
        StepVerifier
                .create(this.stockController.getShopping())
                .expectNextCount(11)
                .expectComplete()
                .verify();
    }
}
