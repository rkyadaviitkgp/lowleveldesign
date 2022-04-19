package code.lowleveldesign.parkinglot;

public class ParkingSlot {

    int slotNumber;
    ParkingSlotType slotType;
    boolean isAvailable;

    public ParkingSlot(int slotNumber, ParkingSlotType slotType) {
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "slotNumber=" + slotNumber +
                ", slotType=" + slotType +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public ParkingSlotType getSlotType() {
        return slotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
