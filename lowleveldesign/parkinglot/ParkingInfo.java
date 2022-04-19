package code.lowleveldesign.parkinglot;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingInfo {

    String id;
    ParkedVehicle parkedVehicle;
    ParkingSlot parkingSlot;

    public ParkingInfo(ParkedVehicle parkedVehicle, ParkingSlot parkingSlot) {
        id = UUID.randomUUID().toString();
        this.parkedVehicle = parkedVehicle;
        this.parkingSlot = parkingSlot;
    }

    @Override
    public String toString() {
        return "ParkingInfo{" +
                "id='" + id + '\'' +
                ", parkedVehicle=" + parkedVehicle +
                ", parkingSlot=" + parkingSlot +
                '}';
    }

    public ParkedVehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(ParkedVehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

}
