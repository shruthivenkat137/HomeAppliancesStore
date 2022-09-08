package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> updateProduct(Product product, int id) {
        Optional<Product> oldproduct = productRepository.findById(id);
        Product foundProduct;
        if (oldproduct.isPresent()) {
            foundProduct = oldproduct.get();
            foundProduct.setProductName(product.getProductName());
            foundProduct.setProductDescription(product.getProductDescription());
            foundProduct.setProductImgUrl(product.getProductImgUrl());
            foundProduct.setProductType(product.getProductType());
            foundProduct.setProductPrice(product.getProductPrice());
            productRepository.save(foundProduct);
        }
        return oldproduct;
    }

    @Override
    public List<Product> viewProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);

    }

    @Override
    public Product getProductById(int productId) {
        Product product = productRepository.findById(productId).get();
        return product;
    }
}