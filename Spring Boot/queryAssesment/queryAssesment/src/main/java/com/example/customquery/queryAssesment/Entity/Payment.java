package com.example.customquery.queryAssesment.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Payment")
@NoArgsConstructor
@AllArgsConstructor

public class Payment {

    @Id
    @Column(name="PaymentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

//    @OneToOne()
//    @JoinColumn(name="OrderId")
//    private Order order;

    @Column(name="OrderId")
    private int orderId;

    @Column(name="PaymentMode")
    private String paymentMode;

    @Column(name="TransactionId")
    private String transactionId;
}
