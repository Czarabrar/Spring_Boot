package com.assesment1.GroceryAssesment.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.assesment1.GroceryAssesment.Entity.Product;
import com.assesment1.GroceryAssesment.Repository.ProductRepository;

@RestController
public class ProductController {

	
	@Autowired
	private ProductRepository productRepository;
	
	
	@PostMapping("/product")
	public ResponseEntity<Product> addproduct(@RequestBody Product product){
		Product newproduct = productRepository.save(product);
		return new ResponseEntity<>(newproduct,HttpStatus.CREATED);
	}
	
	@GetMapping("/product")
	public List<Product> getallcustomer(){
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{ProductId}")
	public ResponseEntity<Product> getCustomerid(@PathVariable Long ProductId){
		Optional<Product> optionalProduct = productRepository.findById(ProductId);
		if(optionalProduct.isPresent()) {
			Product product= optionalProduct.get();
			return ResponseEntity.ok(product);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/product/{ProductId}")
	public ResponseEntity<Product> updateCustomer(@PathVariable Long ProductId,@RequestBody Product newProduct){
		Optional<Product> optionalProduct = productRepository.findById(ProductId);
		if(optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			product.setProductName(newProduct.getProductName());
			product.setPrice(newProduct.getPrice());
			
			
			return ResponseEntity.ok(productRepository.save(product));
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/product/{ProductId}")
	public void DeletebyId(@PathVariable Long ProductId) {
		 productRepository.deleteById(ProductId);
		 
	}

	
}
