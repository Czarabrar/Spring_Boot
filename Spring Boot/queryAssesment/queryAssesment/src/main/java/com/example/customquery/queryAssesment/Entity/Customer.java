package com.example.customquery.queryAssesment.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name="Customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {


    @Id
    @Column(name="customerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }

//    public List<OrderDetails> getOrderDetails() {
//        return orderDetails;
//    }
//
//    public void setOrderDetails(List<OrderDetails> orderDetails) {
//        this.orderDetails = orderDetails;
//    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    @OneToMany(mappedBy = "customer")
//    private List<OrderDetails> orderDetails;

    @Column(name="customerName")
    private String customerName;

    @Column(name="Mobile")
    private int mobile;

    @Column(name="Address")
    private String address;



}
