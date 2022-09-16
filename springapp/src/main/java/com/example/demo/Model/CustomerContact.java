package com.example.demo.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "customer_contact")
@Data
public class CustomerContact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneno;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user", referencedColumnName = "userId")
    private User user;

}