package com.bridgelabz.quantitymeasurement.Service;

import com.bridgelabz.quantitymeasurement.model.QuantityDto;
import com.bridgelabz.quantitymeasurement.model.QuantityName;
import com.bridgelabz.quantitymeasurement.model.Unit;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class QuantityConversionImpl implements IQuantityConversionService {

    @Override
    public List<String> getQuantity() {
        return Stream.of(QuantityName.values()).map(QuantityName::name).collect(Collectors.toList());
    }

    @Override
    public List<Unit> getQuantityUnits(QuantityName quantity) {
        return Arrays.stream(Unit.values()).filter(unit -> unit.quantityName.equals(quantity)).collect(Collectors.toList());
    }

    @Override
    public QuantityDto convertQuantity(QuantityDto quantityDto, Unit unit) {
        double value = quantityDto.getVALUE() * quantityDto.getUNIT().baseUnitConversion
                + quantityDto.getUNIT().additionConstant;
        value = (value - unit.additionConstant) / unit.baseUnitConversion;
        return new QuantityDto(value, unit);
    }
}
