package com.example.demo.Services;

import java.util.List;

import com.example.demo.Model.Cart;
import com.example.demo.Payload.request.CartRequest;
import com.example.demo.Payload.response.CartResponse;

public interface CartService {
    Cart addToCart(CartRequest cart);

    List<CartResponse> getUserCart(Long userId);

    void deleteCartItem(int bookId, Long userId);
}
