package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Cart;
import com.example.demo.Model.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUser(User user);

    Cart getAllByUser(User user);

    @Query(value = "select c from Cart c where c.user.userId=?1")
    List<Cart> getCartByUser(Long id);

    @Query(value = "SELECT c FROM Cart c WHERE c.product.productId=?1 AND c.user.userId=?2")
    Cart getByProductAndUser(int ProductId, Long userId);

}

// @Repository
// public interface CartRepository extends JpaRepository<Cart, Integer> {
// List<Cart> findAllByUser(User user);

// Cart getByProduct(Long long1);

// Cart getAllByUser(User user);

// @Query(value = "select c from Cart c where c.user.userId=?1")
// List<Cart> getCartByUser(Long id);

// @Query(value = "SELECT c FROM Cart c WHERE c.book.bookId=?1 AND
// c.user.userId=?2")
// Cart getByProductUser(int productId, Long userId);
// }
