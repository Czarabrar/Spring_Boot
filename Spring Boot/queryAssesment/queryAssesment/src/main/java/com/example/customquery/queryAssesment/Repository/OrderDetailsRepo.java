package com.example.customquery.queryAssesment.Repository;
import com.example.customquery.queryAssesment.Entity.OrderDetails;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {
   List<OrderDetails> findByCustomerId(int customerId);

    @Query("SELECT SUM(od.totalAmount) " +
            "FROM OrderDetails od " +
            "INNER JOIN Order o ON od.orderId = o.orderId " +
            "WHERE o.orderDate = :orderDate")
    List<Object[]> getdatesummary(@Param("orderDate") Date newdate);


}
