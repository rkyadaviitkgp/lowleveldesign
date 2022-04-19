package code.lowleveldesign.parkinglot;

public enum VehicleType {
    SMALL, MEDIUM, BIG;

    public ParkingSlotType getParkingSpace(VehicleType type){
        if(type == SMALL)
            return ParkingSlotType.SMALL;
        if(type == MEDIUM)
            return ParkingSlotType.MEDIUM;
        return ParkingSlotType.BIG;
    }
}
