package es.upm.miw.betca_tpv_spring.business_controllers;

import es.upm.miw.betca_tpv_spring.TestConfig;
import es.upm.miw.betca_tpv_spring.documents.OrderLine;
import es.upm.miw.betca_tpv_spring.dtos.*;
import es.upm.miw.betca_tpv_spring.repositories.ArticleRepository;
import es.upm.miw.betca_tpv_spring.repositories.ProviderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class OrderControllerIT {

    @Autowired
    private OrderController orderController;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ProviderRepository providerRepository;

    private OrderDto orderDto;

    @BeforeEach
    void seed(){
        OrderLineDto[] orderLines = {
                new OrderLineDto(this.articleRepository.findAll().get(0), 10),
                new OrderLineDto(this.articleRepository.findAll().get(1), 8),
                new OrderLineDto(this.articleRepository.findAll().get(2), 6),
                new OrderLineDto(this.articleRepository.findAll().get(3), 4),
        };

        this.orderDto = new OrderDto("order0", this.providerRepository.findAll().get(0), LocalDateTime.now(), orderLines);
    }

    @Test
    void testSearchOrderByDescriptionOrProvider() {
        OrderSearchDto orderSearchDto =
                new OrderSearchDto("null", this.providerRepository.findAll().get(1).getId(), null);
        StepVerifier
                .create(this.orderController.searchOrder(orderSearchDto))
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }

    @Test
    void testCreateOrder(){
        OrderLineCreationDto[] orderLines = {
                new OrderLineCreationDto(this.articleRepository.findAll().get(0).getCode(), 10),
                new OrderLineCreationDto(this.articleRepository.findAll().get(1).getCode(), 8),
                new OrderLineCreationDto(this.articleRepository.findAll().get(2).getCode(), 6),
                new OrderLineCreationDto(this.articleRepository.findAll().get(3).getCode(), 4),
        };
        OrderCreationDto orderCreationDto = new OrderCreationDto("orderPrueba", this.providerRepository.findAll().get(1).getId(), orderLines);

        StepVerifier
                .create(this.orderController.createOrder(orderCreationDto))
                .expectNextMatches(order -> {
                    assertNotNull(order.getId());
                    assertEquals("orderPrueba", order.getDescription());
                    assertEquals(this.providerRepository.findAll().get(1).getId(), order.getProvider().getId());
                    assertNotNull(order.getOpeningDate());
                    assertEquals(4, order.getOrderLines().length);
                    return true;
                })
                .expectComplete()
                .verify();
    }
}
