package com.example.customquery.queryAssesment.Controller;

import com.example.customquery.queryAssesment.Entity.OrderDetails;
import com.example.customquery.queryAssesment.Service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class OrderDetailsController {
@Autowired
    private OrderDetailsService orderDetailsService;


    @PostMapping("/addorderdetails")
    public ResponseEntity<OrderDetails> addneworderDetails(@RequestBody OrderDetails orderDetails){
        return orderDetailsService.addorderDetails(orderDetails);
    }
    @GetMapping("/order/{date}/summary")
    public List<Object[]> getcustomedate(@PathVariable Date date){
        return orderDetailsService.getcustomdate(date);
    }
}
