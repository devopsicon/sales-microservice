package com.devopsicon.microservices.sales;

import com.devopsicon.microservices.sales.entity.Sales;
import com.devopsicon.microservices.sales.repository.SalesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    @Profile("dev")
    public CommandLineRunner commandLineRunner(ApplicationContext ctx, SalesRepository salesRepository) {
        return args -> {
            Sales sales1 = new Sales();
            sales1.setAmount(1000.00F);
            sales1.setComments("");
            sales1.setItemId(1L);
            sales1.setLocationId(1L);
            sales1.setUserId(1L);

            Sales sales2 = new Sales();
            sales2.setAmount(1500.00F);
            sales2.setComments("");
            sales2.setItemId(2L);
            sales2.setLocationId(1L);
            sales2.setUserId(2L);

            salesRepository.save(sales1);
            salesRepository.save(sales2);
        };
    }
}
