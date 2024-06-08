package com.example.customquery.queryAssesment.Repository;

import com.example.customquery.queryAssesment.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {


    @Query("SELECT p.productName , od.quantity "+
           "FROM Product p "+
            "INNER JOIN OrderDetails od ON p.productId = od.productId "+
            "INNER JOIN Order o ON od.orderId = o.orderId "+
             "WHERE FUNCTION('MONTH',o.orderDate) = :month ")
    List<Object[]> getcustommonth(@Param("month")Integer month);
}
