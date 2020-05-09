package com.bridgelabz.quantitymeasurement.Service;

import com.bridgelabz.quantitymeasurement.model.QuantityDto;
import com.bridgelabz.quantitymeasurement.model.QuantityName;
import com.bridgelabz.quantitymeasurement.model.Unit;

import java.util.List;

public interface IQuantityConversionService {
    public List<String> getQuantity();
    List<Unit> getQuantityUnits(QuantityName quantity);
    QuantityDto convertQuantity(QuantityDto quantityDto,Unit unit);
}
