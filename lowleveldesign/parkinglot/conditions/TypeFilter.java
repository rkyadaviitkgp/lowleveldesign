package code.lowleveldesign.parkinglot.conditions;

import code.lowleveldesign.parkinglot.ParkedVehicle;
import code.lowleveldesign.parkinglot.VehicleType;

public class TypeFilter implements QueryCondition{
    VehicleType type;

    public TypeFilter(VehicleType type) {
        this.type = type;
    }

    @Override
    public boolean isSatisfied(ParkedVehicle parkedVehicle) {
        return parkedVehicle.getType() == type;
    }
}
