package com.example.customquery.queryAssesment.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@Table(name="Orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Column(name="OrderId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Column(name = "CustomerId")
    private int customerId;

    public int getShipperId() {
        return shipperId;
    }

    public void setShipperId(int shipperId) {
        this.shipperId = shipperId;
    }

    @Column(name = "ShipperId")
    private int shipperId;



//    @ManyToOne()
//    @JoinColumn(name="CustomerId")
//    private Customer customer;
//
//    @ManyToOne()
//    @JoinColumn(name="ShipperId")
//    private Shipper shipper;

    @Column(name="order_Date")
    private Date orderDate;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    @Column(name="final_Amount")
    private double finalAmount;



}
