package com.example.demo.Services;

import com.example.demo.Model.Address;

public interface AddressService {
    Address addAddress(Address address, Long userId);

    Address getAddressByUser(Long userId);
}