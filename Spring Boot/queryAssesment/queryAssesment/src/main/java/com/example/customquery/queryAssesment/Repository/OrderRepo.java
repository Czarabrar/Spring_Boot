package com.example.customquery.queryAssesment.Repository;

import com.example.customquery.queryAssesment.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {
}
