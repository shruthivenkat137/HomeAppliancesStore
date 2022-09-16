package com.example.demo.Payload.request;

import lombok.Data;

@Data
public class CartItem {
    private int productId;
    private String productImgUrl;
    private String productName;
    private Double productPrice;
    private int quantity;
}
