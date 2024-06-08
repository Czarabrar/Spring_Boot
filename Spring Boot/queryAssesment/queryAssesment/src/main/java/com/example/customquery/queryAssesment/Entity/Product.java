package com.example.customquery.queryAssesment.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Product")
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    @Id
    @Column(name="ProductId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name="ProductName")
    private String productName;

    @Column(name="Price")
    private double price;

    @Column(name="Quantity")
    private int quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
