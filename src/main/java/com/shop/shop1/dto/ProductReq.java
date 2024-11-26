package com.shop.shop1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReq {
    private String name;
    private Double price;
    private String description;
    private Long categoryId;
    private Integer size;
}
