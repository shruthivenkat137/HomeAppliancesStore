package com.example.demo.Services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Model.Cart;
import com.example.demo.Model.User;
import com.example.demo.Payload.request.CartRequest;
import com.example.demo.Payload.response.CartResponse;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Repository.CartRepository;
import com.example.demo.Repository.UserRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart addToCart(CartRequest cart) {
        Cart cartItem = new Cart();
        User user = userRepository.findById(Long.parseLong(cart.getUserId())).get();
        Product product = productRepository.findById((int) Long.parseLong(cart.getProductId())).get();
        int productId = product.getProductId();
        List<Cart> userCart = cartRepository.findAllByUser(user);
        for (Cart cart2 : userCart) {
            int productId1 = cart2.getProduct().getProductId();
            if (productId == productId1) {
                cart2.setQuantity(cart2.getQuantity() + cart.getQuantity());
                return cartRepository.save(cart2);
            }
        }
        cartItem.setProduct(product);
        cartItem.setUser(user);
        cartItem.setQuantity(cart.getQuantity());
        return cartRepository.save(cartItem);

    }

    public List<CartResponse> getUserCart(Long userId) {
        List<Cart> cartItems = cartRepository.getCartByUser(userId);
        List<CartResponse> userCart = new LinkedList<>();
        for (Cart cart : cartItems) {
            if (cart.getOrderStatus() == null) {
                CartResponse cartResponse = new CartResponse();
                cartResponse.setProductId(cart.getProduct().getProductId());
                cartResponse.setProductImgUrl(cart.getProduct().getProductImgUrl());
                cartResponse.setProductPrice(cart.getProduct().getProductPrice());
                cartResponse.setProductName(cart.getProduct().getProductName());
                cartResponse.setQuantity(cart.getQuantity());
                userCart.add(cartResponse);
            }
        }
        return userCart;
    }

    @Override
    public void deleteCartItem(int productId, Long userId) {
        Cart cartItem = new Cart();
        cartItem = cartRepository.getByProductAndUser(productId, userId);
        cartRepository.delete(cartItem);

    }

}
