package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Product;
import com.example.demo.Payload.response.ViewOrder;
import com.example.demo.Services.OrderService;
import com.example.demo.Services.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")

public class AdminController {
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/addproduct")
    public Product addproduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/editproduct/{productId}")
    public Optional<Product> editproduct(@RequestBody Product product, @PathVariable int productId) {
        return productService.updateProduct(product, productId);
    }

    @GetMapping("/getProductById/{productId}")
    public Product getProductById(@PathVariable int productId) {
        System.out.println(productService.getProductById(productId));
        return productService.getProductById(productId);
    }

    @GetMapping("/viewproducts")
    public List<Product> viewproducts() {
        return productService.viewProducts();
    }

    @DeleteMapping("/deleteproduct/{productId}")
    public void deleteproduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
    }

    @GetMapping("/viewOrders")
    public List<ViewOrder> viewAllOrders() {
        return orderService.viewAllOrders();
    }
}