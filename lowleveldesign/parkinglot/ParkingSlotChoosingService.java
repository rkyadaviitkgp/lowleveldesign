package code.lowleveldesign.parkinglot;

import code.lowleveldesign.parkinglot.exceptions.NoParkingSlotAvailableException;

public interface ParkingSlotChoosingService {
    public ParkingSlot getNextSlot(ParkingSlotType type) throws NoParkingSlotAvailableException;
    public void addSlot(ParkingSlot parkingSlot);
}
