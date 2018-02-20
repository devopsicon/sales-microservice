package com.devopsicon.microservices.sales.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Sales {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Float amount;
    private Long itemId;
    private Long userId;
    private Long locationId;
    private String comments;

    public Sales(){

    }
}
