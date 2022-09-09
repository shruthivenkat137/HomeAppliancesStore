package com.example.demo.Services;

import java.util.List;

import com.example.demo.Model.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer);

    List<Customer> viewCustomers();
}
