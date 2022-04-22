package code.lowleveldesign.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFunctionalityDemo {

    ParkingSystem parkingSystem;
    public static final int MAX_NO = 30;

    public ParkingFunctionalityDemo() {
        List<ParkingSlot> list = new ArrayList<>();
        //create 10 parking slot
        for(int i=0; i<MAX_NO; i++){
            ParkingSlot parkingSlot = null;
            if(i%3 == 0)
                parkingSlot = new ParkingSlot(i, ParkingSlotType.SMALL);
            else if(i%2 == 0)
                parkingSlot = new ParkingSlot(i, ParkingSlotType.MEDIUM);
            else
                parkingSlot = new ParkingSlot(i, ParkingSlotType.BIG);
            list.add(parkingSlot);

        }
        parkingSystem = new ParkingSystem(list);
    }

    public static void main(String[] args) {
        ParkingFunctionalityDemo parkingDemo = new ParkingFunctionalityDemo();
        ParkingSystem parkingSystem = parkingDemo.parkingSystem;

        //ParkedVehicle parkedVehicle = new ParkedVehicle("Wb 38 AG 5777", VehicleColour.RED, VehicleType.SMALL);
        parkingSystem.parkVehicle("Wb 38 AG 5777", VehicleType.SMALL, VehicleColour.RED);
        parkingSystem.parkVehicle("Wb 38 AG 5778", VehicleType.SMALL, VehicleColour.BLUE);
        parkingSystem.parkVehicle("Wb 38 AG 5779", VehicleType.BIG, VehicleColour.WHITE);
        parkingSystem.parkVehicle("Wb 38 AG 5789", VehicleType.MEDIUM, VehicleColour.BLUE);
        parkingSystem.parkVehicle("Wb 38 AG 5771", VehicleType.SMALL, VehicleColour.RED);

        System.out.println(parkingSystem.getSpotNumber("Wb 38 AG 5771"));
        parkingSystem.printParkingSpace();

    }

}
