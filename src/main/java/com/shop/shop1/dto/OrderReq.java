package com.shop.shop1.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderReq {
    private List<Long> productsId;
}
