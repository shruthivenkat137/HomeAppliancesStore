package com.example.demo.Payload.response;

import java.util.Date;
import java.util.List;

import com.example.demo.Payload.request.CartItem;

import lombok.Data;

@Data
public class ViewOrder {
    private Long orderId;
    private Long userId;
    private String userName;
    private String address;
    private Date createdDate;
    private Double amount;
    private List<CartItem> cartItem;

}