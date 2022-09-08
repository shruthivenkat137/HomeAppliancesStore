package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;

@Service
public interface ProductService {
    public Product addProduct(Product product);

    Optional<Product> updateProduct(Product product, int id);

    List<Product> viewProducts();

    void deleteProduct(int id);

    Product getProductById(int productId);
}
