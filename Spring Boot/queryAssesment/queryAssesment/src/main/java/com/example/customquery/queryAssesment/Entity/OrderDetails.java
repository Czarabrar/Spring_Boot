package com.example.customquery.queryAssesment.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="OrderDetails")
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {

    @Id
    @Column(name="orderDetailsId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderDetailsId;

//    @ManyToOne()
//    @JoinColumn(name="OrderId")
//    private Order order;
//
//    @ManyToOne()
//    @JoinColumn(name="customerId")
//    private Customer customer;

//    @ManyToOne()
//    @JoinColumn(name="ProductId")
//    private Product product;


//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }

//    public int getProductId() {
//        return productId;
//    }
//
//    public void setProductId(int productId) {
//        this.productId = productId;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public double getTotalAmount() {
//        return totalAmount;
//    }
//
//    public void setTotalAmount(double totalAmount) {
//        this.totalAmount = totalAmount;
//    }

    @Column(name="OrderId")
    private int orderId;

    @Column(name="CustomerId")
    private int customerId;

    @Column(name="ProductId")
    private int productId;


    @Column(name="Quantity")
    private int quantity;

    @Column(name="Total_Amount")
    private double totalAmount;

}
