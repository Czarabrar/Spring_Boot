package com.example.customquery.queryAssesment.Repository;

import com.example.customquery.queryAssesment.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {
}
