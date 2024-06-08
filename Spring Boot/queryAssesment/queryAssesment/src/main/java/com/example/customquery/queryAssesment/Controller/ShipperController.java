package com.example.customquery.queryAssesment.Controller;

import com.example.customquery.queryAssesment.Entity.Shipper;
import com.example.customquery.queryAssesment.Service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ShipperController {
    @Autowired
    private ShipperService shipperService;


    @PostMapping("/addshipper")
    public Shipper addshipper(@RequestBody Shipper shipper){
        return shipperService.addnewshipper(shipper);
    }
    @GetMapping("/getshipper")
    public List<Shipper> getAllShipper(){
        return shipperService.getallShipper();
    }
    @GetMapping("/getshipper/{id}")
    public Optional<Shipper> getShipperId(@PathVariable int id){
        return shipperService.getShipperDetails(id);
    }

    @PutMapping("/update/{id}")
    public Shipper updateshipper(@PathVariable int id, @RequestBody  Shipper shipper){
        return shipperService.updateShipper(id,shipper);
    }

    @DeleteMapping("/deleteshipper/{id}")
    public void deleteid(int id){
         shipperService.deleteid(id);
    }

    @GetMapping("/{id}/summary")
    public List<Object[]>getcustomship(@PathVariable int id){
        return shipperService.getshipperdetails(id);
    }
}
