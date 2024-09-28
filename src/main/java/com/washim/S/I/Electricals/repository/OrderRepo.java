package com.washim.S.I.Electricals.repository;

import com.washim.S.I.Electricals.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}