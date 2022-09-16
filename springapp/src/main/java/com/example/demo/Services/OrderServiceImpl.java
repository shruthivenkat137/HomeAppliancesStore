package com.example.demo.Services;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.Product;
import com.example.demo.Model.Cart;
import com.example.demo.Model.Order;
import com.example.demo.Model.User;
import com.example.demo.Payload.request.CartItem;
import com.example.demo.Payload.request.OrderRequest;
import com.example.demo.Payload.response.ViewOrder;
import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Repository.CartRepository;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public Order placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setAmount(orderRequest.getAmount());// get data from order request
        List<Cart> cartItems = new LinkedList<Cart>();
        User user = userRepository.findById(orderRequest.getUserId()).get();
        for (CartItem cart : orderRequest.getCartItem()) {
            Product product = productRepository.findById(cart.getProductId()).get();
            Cart temp = new Cart();
            Cart item = cartRepository.getByProductAndUser(cart.getProductId(), user.getUserId());
            cartRepository.delete(item);
            temp.setProduct(product);
            temp.setQuantity(cart.getQuantity());
            temp.setUser(user);
            temp.setOrderStatus("Placed");
            System.out.println(temp.toString());
            cartItems.add(temp);

        }

        order.setUser(userRepository.getByUserId(orderRequest.getUserId()));// get and set user id
        order.setAddress(addressRepository.findAddressByUser(orderRequest.getUserId()));// get and set address
        order.setCartItem(cartItems);// get and set cart items
        return orderRepository.save(order);
    }

    @Override
    public List<ViewOrder> viewOrders(Long userId) {
        List<Order> orders = orderRepository.getOrderByUser(userId);
        List<ViewOrder> responseItem = new LinkedList<>();
        for (Order order : orders) {
            ViewOrder item = new ViewOrder();
            item.setAddress(order.getAddress().getCity());
            item.setAmount(order.getAmount());
            item.setCreatedDate(order.getCreatedDate());
            item.setOrderId(order.getOrderId());
            item.setUserId(userId);
            item.setUserName(userRepository.getByUserId(userId).getUserName());
            List<CartItem> cartItems = new LinkedList<>();
            for (Cart citem : order.getCartItem()) {
                CartItem cartItem = new CartItem();
                cartItem.setProductId(citem.getProduct().getProductId());
                cartItem.setProductImgUrl(citem.getProduct().getProductImgUrl());
                cartItem.setProductPrice(citem.getProduct().getProductPrice());
                cartItem.setProductName(citem.getProduct().getProductName());
                cartItem.setQuantity(citem.getQuantity());
                cartItems.add(cartItem);

            }
            item.setCartItem(cartItems);
            responseItem.add(item);

        }
        return responseItem;
    }

    @Override
    public List<ViewOrder> viewAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<ViewOrder> responseItem = new LinkedList<>();
        for (Order order : orders) {
            ViewOrder item = new ViewOrder();
            item.setAddress(order.getAddress().getCity());
            item.setAmount(order.getAmount());
            item.setCreatedDate(order.getCreatedDate());
            item.setOrderId(order.getOrderId());
            item.setUserId(order.getUser().getUserId());
            item.setUserName(userRepository.getByUserId(order.getUser().getUserId()).getUserName());
            List<CartItem> cartItems = new LinkedList<>();
            for (Cart citem : order.getCartItem()) {
                CartItem cartItem = new CartItem();
                cartItem.setProductId(citem.getProduct().getProductId());
                cartItem.setProductImgUrl(citem.getProduct().getProductImgUrl());
                cartItem.setProductPrice(citem.getProduct().getProductPrice());
                cartItem.setProductName(citem.getProduct().getProductName());
                cartItem.setQuantity(citem.getQuantity());
                cartItems.add(cartItem);

            }
            item.setCartItem(cartItems);
            responseItem.add(item);

        }
        return responseItem;
    }

}
