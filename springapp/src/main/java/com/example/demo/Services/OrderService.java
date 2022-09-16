package com.example.demo.Services;

import java.util.List;

import com.example.demo.Model.Order;
import com.example.demo.Payload.request.OrderRequest;
import com.example.demo.Payload.response.ViewOrder;

public interface OrderService {
    Order placeOrder(OrderRequest orderRequest);

    List<ViewOrder> viewOrders(Long userId);

    List<ViewOrder> viewAllOrders();

}
