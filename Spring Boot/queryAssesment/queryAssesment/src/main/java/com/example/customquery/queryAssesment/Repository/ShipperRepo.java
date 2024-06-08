package com.example.customquery.queryAssesment.Repository;

import com.example.customquery.queryAssesment.Entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface ShipperRepo extends JpaRepository<Shipper,Integer> {

    @Query("SELECT c.customerId , c.customerName , c.address , "+
            "FUNCTION('GROUP_CONCAT', p.productName, ', ') AS allProducts "+
            "FROM Customer c "+
            "INNER JOIN OrderDetails od ON c.customerId = od.customerId "+
            "INNER JOIN Product p ON p.productId = od.productId "+
            "INNER JOIN Order d ON od.orderId = d.orderId "+
            "WHERE shipperId = :shipperId "+
            "GROUP BY c.customerId,c.customerName")
    List<Object[]>getshipsummary(@Param("shipperId")int id);
}

