package code.lowleveldesign.parkinglot.conditions;

import code.lowleveldesign.parkinglot.ParkedVehicle;
import code.lowleveldesign.parkinglot.VehicleColour;
import code.lowleveldesign.parkinglot.VehicleType;

public class ColourFilter implements QueryCondition{
    VehicleColour colour;

    public ColourFilter(VehicleColour colour) {
        this.colour = colour;
    }

    @Override
    public boolean isSatisfied(ParkedVehicle parkedVehicle) {
        return parkedVehicle.getColour() == colour;
    }
}
