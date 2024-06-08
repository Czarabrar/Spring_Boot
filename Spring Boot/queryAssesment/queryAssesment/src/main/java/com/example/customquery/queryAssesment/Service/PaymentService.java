package com.example.customquery.queryAssesment.Service;

import com.example.customquery.queryAssesment.Entity.Payment;
import com.example.customquery.queryAssesment.Repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;


    public Payment newpayment(Payment payment){
        return paymentRepo.save(payment);
    }
}
