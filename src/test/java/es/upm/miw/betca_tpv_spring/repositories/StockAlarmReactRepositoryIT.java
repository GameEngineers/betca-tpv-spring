package es.upm.miw.betca_tpv_spring.repositories;

import es.upm.miw.betca_tpv_spring.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
class StockAlarmReactRepositoryIT {

    @Autowired
    private StockAlarmReactRepository stockAlarmReactRepository;

//    @Test
//    void testReadAllAndDatabaseSeeder() {
//        StepVerifier
//                .create(this.stockAlarmReactRepository.findAll())
//                .expectNextMatches(stockAlarm -> {
//                    assertEquals("222", stockAlarm.getId());
//                    assertEquals("2222", stockAlarm.getDescription());
//                    assertEquals("upm", stockAlarm.getProvider());
//                    assertNotNull(stockAlarm.getAlarmArticle());
//                    assertEquals(new Integer(2), stockAlarm.getWarning());
//                    assertEquals(new Integer(2), stockAlarm.getCritical());
//                    assertNotNull(stockAlarm.getAlarmArticle());
//                    return true;
//                })
//                .thenCancel()
//                .verify();
//    }
}
