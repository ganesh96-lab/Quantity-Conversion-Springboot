package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.Service.IQuantityConversionService;
import com.bridgelabz.quantitymeasurement.model.QuantityDto;
import com.bridgelabz.quantitymeasurement.model.QuantityName;
import com.bridgelabz.quantitymeasurement.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuantityConversionController {
    @Autowired
    IQuantityConversionService iQuantityConversionService;

    @GetMapping("/quantity")
    public ResponseEntity getQuantityList(){
        return new ResponseEntity(iQuantityConversionService.getQuantity(), HttpStatus.OK);
    }
    @GetMapping("/quantity/{quantityName}")
    public ResponseEntity getUnitList(@PathVariable QuantityName quantityName){
        return new ResponseEntity(iQuantityConversionService.getQuantityUnits(quantityName),HttpStatus.OK);
    }

    @PostMapping("/quantity/conversion/{userUnit}")
    public ResponseEntity convertQuantityInUnit(@RequestBody QuantityDto quantityDto, @PathVariable Unit userUnit){
        return new ResponseEntity(iQuantityConversionService.convertQuantity(quantityDto,userUnit),HttpStatus.OK);
    }
}
