package com.example.customquery.queryAssesment.Service;

import com.example.customquery.queryAssesment.Entity.Product;
import com.example.customquery.queryAssesment.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;


    public Product newProduct(Product product){
    return  productRepo.save(product);
    }

    public List<Product> getallProduct(){
        return productRepo.findAll();
    }

    public Optional<Product> getProductId(int id){
        return productRepo.findById(id);
    }

    public void deleteid(int id){
        productRepo.deleteById(id);
    }

    public List<Object[]> getcustommonth(int month){
        return productRepo.getcustommonth(month);
    }
}
