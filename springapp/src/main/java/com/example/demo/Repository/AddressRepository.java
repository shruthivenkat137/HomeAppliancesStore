package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query(value = "select u from Address u where u.user.userId=?1")
    Address findAddressByUser(Long userId);

}
