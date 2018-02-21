package com.devopsicon.microservices.sales.repository;
import com.devopsicon.microservices.sales.entity.Sale;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SaleRepository extends CrudRepository<Sale, Long>  {
    List<Sale> findByUserId (Long userId);
    List<Sale> findByLocationId (Long locationId);
}
