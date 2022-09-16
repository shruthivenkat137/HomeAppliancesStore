
package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Address;
import com.example.demo.Model.Cart;
import com.example.demo.Model.CustomerContact;
import com.example.demo.Model.Order;
import com.example.demo.Services.CustomerContactService;
import com.example.demo.Services.OrderService;
import com.example.demo.Services.ProductService;

import com.example.demo.Model.Product;
import com.example.demo.Services.AddressService;
import com.example.demo.Services.CartService;

import com.example.demo.Payload.request.CartRequest;
import com.example.demo.Payload.request.OrderRequest;
import com.example.demo.Payload.response.CartResponse;
import com.example.demo.Payload.response.ViewOrder;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerContactService customerContactService;

    @Autowired
    private CartService cartService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/viewproducts")
    public List<Product> viewproducts() {
        return productService.viewProducts();
    }

    @PostMapping("/addToCart")
    public Cart addToCart(@RequestBody CartRequest cart) {
        System.out.println(cart);
        return cartService.addToCart(cart);
    }

    @GetMapping("/getUserCart/{id}")
    public List<CartResponse> getUserCart(@PathVariable String id) {
        Long userId = Long.parseLong(id);
        System.out.println(userId);
        return cartService.getUserCart(userId);
    }

    @DeleteMapping("/deleteCartItem/{productId}/{userId}")
    public void deleteCartItem(@PathVariable Integer productId, @PathVariable Long userId) {
        cartService.deleteCartItem(productId, userId);
    }

    @PostMapping("/addContact/{userId}")
    public CustomerContact addContact(@RequestBody CustomerContact customerContact, @PathVariable Long userId) {
        return customerContactService.addCustomerContact(customerContact, userId);
    }

    @GetMapping("/getContact/{userId}")
    public CustomerContact getContact(@PathVariable Long userId) {
        return customerContactService.getContactByUser(userId);

    }

    @PostMapping("/addAddress/{userId}")
    public Address addAddress(@RequestBody Address address, @PathVariable Long userId) {
        return addressService.addAddress(address, userId);
    }

    @GetMapping("/getAddress/{userId}")
    public Address getAddress(@PathVariable Long userId) {
        return addressService.getAddressByUser(userId);

    }

    @PostMapping("/placeOrder")
    public Order placeOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest);
    }

    @GetMapping("/viewOrders/{userId}")
    public List<ViewOrder> viewOrders(@PathVariable Long userId) {
        return orderService.viewOrders(userId);
    }

    // @DeleteMapping("/cancelOrder/{id}")
    // public String deleteProducts(@PathVariable Long id) {
    // Order product = orderService.findById(id);
    // orderRepository.delete(product);
    // return "deleted";
    // }

    // @PutMapping("/editOrder/{id}")
    // public ResponseEntity<Order> updateUser(@PathVariable Long id, @RequestBody
    // Order order) {
    // Order orders = orderService.findById(id);
    // orders.setUser(order.getUser());

    // orders.setCartItem(order.getCartItem());
    // orders.setAmount(order.getAmount());
    // orders.setAddress(order.getAddress());
    // orders.setCreatedDate(order.getCreatedDate());
    // order.updatedOrder = orderRepository.save(orders);
    // return ResponseEntity.ok(updatedOrder);

    // }
}
// @PostMapping("/placeorder")
// public PurchaseResponse purchase(@RequestBody PurchaseRequest purchase) {
// PurchaseResponse response = this.orderService.placeOrder(purchase);
// return response;
// }
