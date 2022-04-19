package code.lowleveldesign.parkinglot.conditions;

import code.lowleveldesign.parkinglot.ParkedVehicle;

public interface QueryCondition {
    public boolean isSatisfied(ParkedVehicle parkedVehicle);
}
