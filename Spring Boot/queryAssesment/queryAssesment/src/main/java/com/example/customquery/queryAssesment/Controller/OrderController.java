package com.example.customquery.queryAssesment.Controller;

import com.example.customquery.queryAssesment.Entity.Order;
import com.example.customquery.queryAssesment.Service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/addorder")
    public ResponseEntity<Order> addorder(@RequestBody Order order){
        return orderService.addneworder(order);
    }
    @GetMapping("/getorder")
    public List<Order> getorder(){
        return orderService.getAllOrder();
    }
}
