package com.assesment1.GroceryAssesment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.assesment1.GroceryAssesment.Entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
