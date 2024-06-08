package com.assesment1.GroceryAssesment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assesment1.GroceryAssesment.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
