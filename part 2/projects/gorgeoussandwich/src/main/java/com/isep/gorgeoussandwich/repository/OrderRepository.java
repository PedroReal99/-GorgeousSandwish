package com.isep.gorgeoussandwich.repository;

import com.isep.gorgeoussandwich.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(long userId);

}
