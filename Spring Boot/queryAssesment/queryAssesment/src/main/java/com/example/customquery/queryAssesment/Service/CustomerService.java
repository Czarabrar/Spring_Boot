package com.example.customquery.queryAssesment.Service;


import com.example.customquery.queryAssesment.Entity.Customer;
import com.example.customquery.queryAssesment.Entity.Shipper;
import com.example.customquery.queryAssesment.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public Customer addNewCustomer(Customer customer){
        return customerRepo.save(customer);
    }
    public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }
    public Optional<Customer> getCustomerId(long id){
        return customerRepo.findById(id);
    }
    public void deleteCustomer(Long id){
         customerRepo.deleteById(id);
    }

//    public List<Object[]>getcustomquery(int id){
//        Optional<Customer> optionalCustomer = customerRepo.findById(id);
//        return customerRepo.getCustomerSummary(id);
//    }
    public Customer updatecustomer(Long id,Customer customer){

            Optional<Customer> optionalCustomer = customerRepo.findById(id);
            if(optionalCustomer.isPresent()){
                Customer old = optionalCustomer.get();
                old.setCustomerName(customer.getCustomerName());
                old.setAddress(customer.getAddress());
                return customerRepo.save(old);
            }else{
                throw new RuntimeException();
            }

        }
    }
public List<Object[]> getCustomerSummary(Long id) {
    return customerRepo.getCustomerSummary(id);
}
 }

