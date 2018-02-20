package com.devopsicon.microservices.sales.repository;
import com.devopsicon.microservices.sales.entity.Sales;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalesRepository extends CrudRepository<Sales, Long>  {
    List<Sales> findByUserId (Long userId);
    List<Sales> findByLocationId (Long locationId);
}
