package com.example.demo.Model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

@Table(name = "user_data", uniqueConstraints = {

        @UniqueConstraint(columnNames = {
                "username"
        }),

        @UniqueConstraint(columnNames = {
                "email"
        })
})

@Entity

public class User {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fullName;
    private String userName;
    @Email
    private String email;
    private String password;
    private String phoneno;

    @ManyToMany(fetch = FetchType.LAZY)

    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {

    }

    public User(String fullName, String userName, String email, String password, String phoneno) {

        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phoneno = phoneno;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneno() {
        return this.phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
