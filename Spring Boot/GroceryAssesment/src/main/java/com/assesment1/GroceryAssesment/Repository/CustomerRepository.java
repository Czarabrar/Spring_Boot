package com.assesment1.GroceryAssesment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assesment1.GroceryAssesment.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
