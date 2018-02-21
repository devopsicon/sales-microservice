package com.devopsicon.microservices.sales.repository;

import com.devopsicon.microservices.sales.entity.Sale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class SalesRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SaleRepository repository;

    @Test
    public void findByUserId() throws Exception {
        Sale sales1 = new Sale();
        sales1.setAmount(1000.00F);
        sales1.setComments("");
        sales1.setItemId(1L);
        sales1.setLocationId(1L);
        sales1.setUserId(1L);

        this.entityManager.persist(sales1);
        List<Sale> salesReturned = repository.findByUserId(1L);
        assertThat(salesReturned.size()).isEqualTo(1);
        Sale retVal = salesReturned.get(0);
        assertThat(retVal.getAmount()).isEqualTo(1000.00F);
        assertThat(retVal.getItemId()).isEqualTo(1L);
        assertThat(retVal.getLocationId()).isEqualTo(1L);
        assertThat(retVal.getUserId()).isEqualTo(1L);
    }
}