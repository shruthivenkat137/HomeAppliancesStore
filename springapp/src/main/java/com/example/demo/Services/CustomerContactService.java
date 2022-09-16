package com.example.demo.Services;

import com.example.demo.Model.CustomerContact;

public interface CustomerContactService {
    CustomerContact addCustomerContact(CustomerContact customer, Long userId);

    CustomerContact getContactByUser(Long userId);

}
