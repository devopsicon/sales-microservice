package com.devopsicon.microservices.sales.controller;

import com.devopsicon.microservices.sales.entity.Sale;
import com.devopsicon.microservices.sales.repository.SaleRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SalesControllerTest {

    @Mock
    SaleRepository saleRepository;

    @Mock
    Sale saleMock1;


    @InjectMocks
    SalesController salesController;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSales() {
        salesController.getSales();
        Mockito.verify(saleRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void createSales() {
        salesController.createSales(saleMock1);
        Mockito.verify(saleRepository, Mockito.times(1)).save(saleMock1);
    }

    @Test
    public void getSaleById() {
        salesController.getSaleById(1L);
        Mockito.verify(saleRepository, Mockito.times(1)).findOne(1L);
    }
}