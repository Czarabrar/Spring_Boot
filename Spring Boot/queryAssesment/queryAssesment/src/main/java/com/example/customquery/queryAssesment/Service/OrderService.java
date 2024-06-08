package com.example.customquery.queryAssesment.Service;

import com.example.customquery.queryAssesment.Entity.Customer;
import com.example.customquery.queryAssesment.Entity.Order;
import com.example.customquery.queryAssesment.Entity.OrderDetails;
import com.example.customquery.queryAssesment.Repository.CustomerRepo;
import com.example.customquery.queryAssesment.Repository.OrderDetailsRepo;
import com.example.customquery.queryAssesment.Repository.OrderRepo;
import com.example.customquery.queryAssesment.Repository.ShipperRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ShipperRepo shipperRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private CustomerRepo customerRepo;
    public ResponseEntity<Order> addneworder(Order order){

        List<OrderDetails> orderDetailsList = orderDetailsRepo.findByCustomerId(order.getCustomerId());

        double totalAmount = 0.0;
        for(OrderDetails orderDetails:orderDetailsList){
            totalAmount += orderDetails.getTotalAmount();
        }
        order.setFinalAmount(totalAmount);
        Order savedorder = orderRepo.save(order);
        return ResponseEntity.ok(savedorder);
    }

    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }


}
