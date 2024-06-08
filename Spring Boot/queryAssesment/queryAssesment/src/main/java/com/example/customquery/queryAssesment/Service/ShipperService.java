package com.example.customquery.queryAssesment.Service;

import com.example.customquery.queryAssesment.Entity.Customer;
import com.example.customquery.queryAssesment.Entity.Shipper;
import com.example.customquery.queryAssesment.Repository.ShipperRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ShipperService {

    @Autowired
    private ShipperRepo shipperRepo;

    public Shipper addnewshipper(Shipper shipper){
        return shipperRepo.save(shipper);
    }
    public List<Shipper> getallShipper(){
        return shipperRepo.findAll();
    }
    public Optional<Shipper> getShipperDetails(int id){
        return shipperRepo.findById(id);
    }

    public Shipper updateShipper(int id,Shipper shipper){
        Optional<Shipper> optionalShipper = shipperRepo.findById(id);
        if(optionalShipper.isPresent()){
            Shipper old = optionalShipper.get();
            old.setShipperName(shipper.getShipperName());
            old.setMobile(shipper.getMobile());
            old.setVehicleName(shipper.getVehicleName());
            old.setVehicleNumber(shipper.getVehicleNumber());
            return shipperRepo.save(old);
        }else{
            throw new RuntimeException();
        }

    }
    public void deleteid(int id){
        shipperRepo.deleteById(id);
    }

    public List<Object[]> getshipperdetails(int id){
        return shipperRepo.getshipsummary(id);
    }
}
