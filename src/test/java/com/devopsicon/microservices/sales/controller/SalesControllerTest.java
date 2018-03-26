package com.devopsicon.microservices.sales.controller;

import com.devopsicon.microservices.sales.entity.Sale;
import com.devopsicon.microservices.sales.repository.SaleRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

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
        // Create mock entry
        List<Sale> salesList = new ArrayList<>();
        salesList.add(saleMock1);

        //Mock dependency's method return
        Mockito.when(saleRepository.findAll()).thenReturn(salesList);

        //We expect method to return mocked list
        Assert.assertEquals(salesController.getSales(), salesList);

        //We expect method to call dependency only once
        Mockito.verify(saleRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void createSales() {
        salesController.createSales(saleMock1);

        //We expect method to call dependency only once
        Mockito.verify(saleRepository, Mockito.times(1)).save(saleMock1);
    }

    @Test
    public void getSaleById() {
        //Mock dependency's method return
        Mockito.when(saleRepository.findOne(1L)).thenReturn(saleMock1);

        //We expect method to mock sale
        Assert.assertEquals(salesController.getSaleById(1L), saleMock1);

        //We expect method to call dependency only once
        Mockito.verify(saleRepository, Mockito.times(1)).findOne(1L);
    }

    @Test
    public void deleteSaleById() {
        salesController.deleteSaleById(1L);

        //We expect method to call dependency only once
        Mockito.verify(saleRepository, Mockito.times(1)).delete(1L);
    }
}