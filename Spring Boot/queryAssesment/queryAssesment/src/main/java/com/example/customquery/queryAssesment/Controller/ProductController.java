package com.example.customquery.queryAssesment.Controller;

import com.example.customquery.queryAssesment.Entity.Product;
import com.example.customquery.queryAssesment.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addproduct")
    public Product newProduct(@RequestBody Product product){
        return productService.newProduct(product);
    }
    @GetMapping("/getproduct")
    public List<Product> getallproduct(){
        return productService.getallProduct();
    }
    @GetMapping("/getproduct/{id}")
    public Optional<Product> getproductId(@PathVariable int id){
        return productService.getProductId(id);
    }

    @GetMapping("product/{month}/summary")
    public List<Object[]> getcustomdate(@PathVariable int month){
        return productService.getcustommonth(month);
    }
    @DeleteMapping("/deleteproduct/{id}")
    public void deleteproductid(@PathVariable int id){
        productService.deleteid(id);
    }
}
