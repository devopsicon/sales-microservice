package com.devopsicon.microservices.sales.controller;

import com.devopsicon.microservices.sales.entity.Sale;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SalesControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getSales() {
        ResponseEntity<List<Sale>> rateResponse  = this.restTemplate.exchange("/sales/", HttpMethod.GET,
               null, new ParameterizedTypeReference<List<Sale>>(){});
        List<Sale> list = rateResponse.getBody();
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void createSales() {
        Sale sales1 = new Sale();
        sales1.setAmount(1000.00F);
        sales1.setComments("");
        sales1.setItemId(1L);
        sales1.setLocationId(1L);
        sales1.setUserId(1L);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();

        headers.add("Content-Type", "application/json");
        HttpEntity<Sale> request = new HttpEntity<Sale>(sales1, headers);

        Boolean returnBool = restTemplate.postForObject("/sales/", request, Boolean.class);

        assertThat(returnBool).isNull();
    }

    @Test
    public void getSaleById() {
    }
}