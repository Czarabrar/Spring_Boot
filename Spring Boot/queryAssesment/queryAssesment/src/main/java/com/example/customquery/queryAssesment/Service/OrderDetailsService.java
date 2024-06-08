package com.example.customquery.queryAssesment.Service;

import com.example.customquery.queryAssesment.Entity.Customer;
import com.example.customquery.queryAssesment.Entity.Order;
import com.example.customquery.queryAssesment.Entity.OrderDetails;
import com.example.customquery.queryAssesment.Entity.Product;
import com.example.customquery.queryAssesment.Repository.CustomerRepo;
import com.example.customquery.queryAssesment.Repository.OrderDetailsRepo;
import com.example.customquery.queryAssesment.Repository.OrderRepo;
import com.example.customquery.queryAssesment.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;


    @Autowired
    private ProductRepo productRepo;

    public ResponseEntity<OrderDetails> addorderDetails(@RequestBody OrderDetails newOrderDetails) {
        Optional<Product> optionalProduct = productRepo.findById(newOrderDetails.getProductId());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            int quantity = newOrderDetails.getQuantity();
            if (quantity < 1 || quantity > product.getQuantity()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setProductId(newOrderDetails.getProductId());
            orderDetails.setQuantity(quantity);
            orderDetails.setCustomerId(newOrderDetails.getCustomerId());
            orderDetails.setOrderId(newOrderDetails.getOrderId());
            double totalAmount = quantity * product.getPrice();
            orderDetails.setTotalAmount(totalAmount);
            OrderDetails savedOrderDetails = orderDetailsRepo.save(orderDetails);
            product.setQuantity(product.getQuantity() - quantity);
            productRepo.save(product);
            return ResponseEntity.ok(savedOrderDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List<Object[]> getcustomdate(Date date){
        return orderDetailsRepo.getdatesummary(date);
    }
}
