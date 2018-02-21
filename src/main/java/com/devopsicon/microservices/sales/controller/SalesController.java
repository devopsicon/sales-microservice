package com.devopsicon.microservices.sales.controller;

import org.springframework.web.bind.annotation.RestController;

import com.devopsicon.microservices.sales.entity.Sale;
import com.devopsicon.microservices.sales.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    SaleRepository saleRepository;

    @RequestMapping("/")
    public Iterable<Sale> getSales() {
        return saleRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void createSales(@RequestBody Sale sale) {
        saleRepository.save(sale);
    }

    @RequestMapping("/{id}")
    public Sale getSaleById(@PathVariable(value="id") Long id) {
        return saleRepository.findOne(id);
    }
}
