package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.CustomerContact;

public interface CustomerContactRepository extends JpaRepository<CustomerContact, Long> {
    @Query(value = "select u from CustomerContact u where u.user.userId=?1")
    void save(CustomerContactRepository customerContactRepository);

    CustomerContact findContactByUser(Long userId);
}
