package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Address;
import com.example.demo.Model.User;
import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.UserRepository;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address addAddress(Address address, Long userId) {
        User user = userRepository.findById(userId).get();
        address.setUser(user);
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressByUser(Long userId) {
        return addressRepository.findAddressByUser(userId);
    }

}
