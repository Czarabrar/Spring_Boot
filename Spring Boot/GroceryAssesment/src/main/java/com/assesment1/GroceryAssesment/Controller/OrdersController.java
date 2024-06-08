package com.assesment1.GroceryAssesment.Controller;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assesment1.GroceryAssesment.Entity.Customer;
import com.assesment1.GroceryAssesment.Entity.Orders;
import com.assesment1.GroceryAssesment.Entity.Product;
import com.assesment1.GroceryAssesment.Repository.CustomerRepository;
import com.assesment1.GroceryAssesment.Repository.OrdersRepository;
import com.assesment1.GroceryAssesment.Repository.ProductRepository;

@RestController
public class OrdersController {
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;
	
	
	@PostMapping("/orders")
	public ResponseEntity<Orders> createOrder(@RequestBody Orders neworder){
		
		System.out.println("IN");
		
	    if (neworder.getCustomerId() == null) {
//	    	System.out.println("1");
//	    	System.out.println(neworder.getCustomer());
//	    	System.out.println(neworder.getCustomer().getCustomerId());
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    }
		Optional<Customer> optionalcustomer = customerRepository.findById(neworder.getCustomerId());
		
		if(optionalcustomer.isEmpty()) {
			System.out.println("2");
			System.out.println(neworder.getCustomerId());
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		Customer customer = optionalcustomer.get(); 

		Optional<Product> optionalproduct = productRepository.findById(neworder.getCustomerId());
		
		if(!optionalproduct.isPresent()) {
			System.out.println("3");
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		Product product = optionalproduct.get();
		
		int quantity = neworder.getQuantity();
		if(quantity < 1 || quantity > product.getQuantity()) {
			System.out.println("4");
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}
		Orders orders = new Orders();
		LocalDate localDate = LocalDate.now();
		orders.setCustomerId(neworder.getCustomerId());
		orders.setProductId(neworder.getProductId());
		orders.setQuantity(quantity);
		orders.setOrderDate(localDate);
		
		double totalamount = quantity * product.getPrice();
		orders.setTotalAmout(totalamount);
		product.setQuantity(product.getQuantity()-quantity);
		productRepository.save(product);
		return ResponseEntity.ok(ordersRepository.save(orders));
	
}
	@GetMapping("/orders")
	public List<Orders> getallorder(){
		return ordersRepository.findAll();
	}
	
	
	
	
	
	}
