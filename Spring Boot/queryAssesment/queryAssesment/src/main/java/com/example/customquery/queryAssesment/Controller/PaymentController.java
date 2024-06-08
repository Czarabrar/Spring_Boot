package com.example.customquery.queryAssesment.Controller;

import com.example.customquery.queryAssesment.Entity.Payment;
import com.example.customquery.queryAssesment.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/addpayment")
    public Payment newpayment(@RequestBody Payment payment){
        return paymentService.newpayment(payment);
    }

}
