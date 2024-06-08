package com.example.customquery.queryAssesment.Repository;

import com.example.customquery.queryAssesment.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    @Query("SELECT c.customerId, c.customerName,COUNT(od.productId), SUM(od.totalAmount) " +
            "FROM Customer c " +
            "LEFT JOIN OrderDetails od ON c.customerId = od.customerId " +
            "WHERE c.customerId = :customerId " +
            "GROUP BY c.customerId, c.customerName")
    List<Object[]> getCustomerSummary(@Param("customerId") long id);



}
