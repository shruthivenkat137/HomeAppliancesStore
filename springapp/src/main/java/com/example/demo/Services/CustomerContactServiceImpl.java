package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.CustomerContact;
import com.example.demo.Model.User;
import com.example.demo.Repository.CustomerContactRepository;
import com.example.demo.Repository.UserRepository;

@Service
public class CustomerContactServiceImpl implements CustomerContactService {

    @Autowired
    CustomerContactRepository customerContactRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomerContact addCustomerContact(CustomerContact customerContact, Long userId) {
        User user = userRepository.findById(userId).get();
        customerContact.setUser(user);
        return customerContactRepository.save(customerContact);
    }

    @Override
    public CustomerContact getContactByUser(Long userId) {

        return customerContactRepository.findContactByUser(userId);
    }
}
