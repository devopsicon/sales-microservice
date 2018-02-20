package com.devopsicon.microservices.sales.controller;

import com.devopsicon.microservices.sales.entity.Sales;
import com.devopsicon.microservices.sales.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    SalesRepository salesRepository;

    @RequestMapping("/")
    public Iterable<Sales> salesList() {
        return salesRepository.findAll();
    }
}
