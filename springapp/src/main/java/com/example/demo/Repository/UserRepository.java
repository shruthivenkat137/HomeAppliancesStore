
package com.example.demo.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

    Optional<User> findById(Long id);

    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);

    @Query(value = "select u.id,u.userName,u.phoneno,u.email from users u", nativeQuery = true)
    public List<Map<String, Object>> getAllUsers();

}
