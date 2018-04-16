package com.devopsicon.microservices.sales.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Float amount;
    @NotNull
    private Long itemId;
    @NotNull
    private Long userId;
    @NotNull
    private Long locationId;
    @NotNull
    private String comments;
}
