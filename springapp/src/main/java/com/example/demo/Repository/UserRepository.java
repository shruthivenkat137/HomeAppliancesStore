
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

    Optional<User> findById(Long userId);

    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);

    @Query(value = "select u.userId,u.userName,u.phoneno,u.email from users u", nativeQuery = true)
    public List<Map<String, Object>> getAllUsers();

    User getByUserId(Long userId);

    User getByUserName(String userName);

}
