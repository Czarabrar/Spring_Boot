package com.example.customquery.queryAssesment.Controller;

import com.example.customquery.queryAssesment.Entity.Customer;
import com.example.customquery.queryAssesment.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("/addcustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addNewCustomer(customer);
    }
    @GetMapping("/getcustomer")
    public List<Customer> getCustomer(){
        return customerService.getAllCustomer();
    }
    @GetMapping("/getcustomer/{id}")
    public Optional<Customer> getCustomerId(@PathVariable Long id){
        return customerService.getCustomerId(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCustomerId(@PathVariable Long id){
         customerService.deleteCustomer(id);
    }

//    @GetMapping("/custom/{id}")
//    public List<Object[]> getCustomerSummary(@PathVariable int id) {
//        return customerService.getcustomquery(id);
//    }
    @PutMapping("/update/{id}")
    public Customer updatecustomer(@PathVariable Long id,@RequestBody Customer customer){
        return customerService.updatecustomer(id,customer);
    }
    @GetMapping("/customer/{id}/summary")
    public List<Object[]> getCustomerSummary(@PathVariable Long id) {
        return customerService.getCustomerSummary(id);
    }
}
