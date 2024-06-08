package com.example.customquery.queryAssesment.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Shipper")
@NoArgsConstructor
@AllArgsConstructor

public class Shipper {

    @Id
    @Column(name="ShipperId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shipperId;

    @Column(name="ShipperName")
    private String shipperName;

    @Column(name="Mobile")
    private int mobile;

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    @Column(name="VehicleName")
    private String VehicleName;

    @Column(name="VehicleNumber")
    private String vehicleNumber;

    public String getVehicleName() {
        return VehicleName;
    }

    public void setVehicleName(String vehicleName) {
        VehicleName = vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
