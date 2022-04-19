package code.lowleveldesign.parkinglot.exceptions;

public class NoParkingSlotAvailableException extends Exception{
    public NoParkingSlotAvailableException() {
    }
    public NoParkingSlotAvailableException(String str) {
        super(str);
    }
}
