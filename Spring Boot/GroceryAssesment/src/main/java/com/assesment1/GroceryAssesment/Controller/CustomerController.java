package com.assesment1.GroceryAssesment.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assesment1.GroceryAssesment.Entity.Customer;
import com.assesment1.GroceryAssesment.Repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping("/customer")
	public ResponseEntity<Customer> addnewCustomer(@RequestBody Customer newCustomer){
		return ResponseEntity.ok(customerRepository.save(newCustomer));
	}
	
	@GetMapping("/customer")
	public List<Customer> getallcustomer(){
		return customerRepository.findAll();
	}
	@GetMapping("/customer/{CustomerId}")
	public ResponseEntity<Customer> getCustomerid(@PathVariable Long CustomerId){
		Customer optionalCustomer = customerRepository.findById(CustomerId).orElse(null);
			return ResponseEntity.ok(optionalCustomer);
		}
		
	
	@PutMapping("/customer/{CustomerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long CustomerId,@RequestBody Customer newCustomer){
		Optional<Customer> optionalCustomer = customerRepository.findById(CustomerId);
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			if (newCustomer.getCustomerName() != null) {
				customer.setCustomerName(newCustomer.getCustomerName());
			}
			if(newCustomer.getAddress()!=null) {
				customer.setAddress(newCustomer.getAddress());				
			}
			if(newCustomer.getMobile()!=0) {
			customer.setMobile(newCustomer.getMobile());
			}
			return ResponseEntity.ok(customerRepository.save(customer));
		}
		return ResponseEntity.ofNullable(null);
	}
	
	@DeleteMapping("/customer/{CustomerId}")
	public void DeletebyId(@PathVariable Long CustomerId) {
		 customerRepository.deleteById(CustomerId);
		 
	}
}
