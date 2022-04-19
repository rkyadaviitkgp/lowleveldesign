package code.lowleveldesign.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingInfoManager {

    HashMap<String, ParkingSlot> vehicleToParkingSlotMap;
    HashMap<Integer, ParkedVehicle> parkingSlotToVehicleMap;
    HashMap<String, ParkingInfo> vehicleToParkinInfoMapping;


    public ParkingInfoManager() {
        vehicleToParkingSlotMap = new HashMap<>();
        parkingSlotToVehicleMap = new HashMap<>();
        vehicleToParkinInfoMapping = new HashMap<>();
    }

    public void addParkingInfo(ParkingInfo parkingInfo){

        ParkedVehicle parkedVehicle = parkingInfo.getParkedVehicle();
        ParkingSlot parkingSlot = parkingInfo.getParkingSlot();

        vehicleToParkingSlotMap.put(parkedVehicle.getVehicleNumber(), parkingSlot);
        parkingSlotToVehicleMap.put(parkingSlot.getSlotNumber(), parkedVehicle);
        vehicleToParkinInfoMapping.put(parkedVehicle.getVehicleNumber(), parkingInfo);

    }

    public void removeParkingInfo(ParkingInfo parkingInfo){

        ParkedVehicle parkedVehicle = parkingInfo.getParkedVehicle();
        ParkingSlot parkingSlot = parkingInfo.getParkingSlot();

        vehicleToParkingSlotMap.remove(parkedVehicle.getVehicleNumber());
        parkingSlotToVehicleMap.remove(parkingSlot.getSlotNumber());
        vehicleToParkinInfoMapping.remove(parkedVehicle.getVehicleNumber());
    }

    //get vehicle parked at slot number
    public ParkedVehicle getParkedVehicle(int slotId){
        return parkingSlotToVehicleMap.getOrDefault(slotId, null);
    }

    //get slot number where vehicle xxx is parked
    public ParkingSlot getParkingSlot(String vehicleNumber){
        return vehicleToParkingSlotMap.getOrDefault(vehicleNumber, null);
    }

    //get parking info for vehicle number xxx
    public ParkingInfo getParkingInfo(String vehicleNumber){
        return vehicleToParkinInfoMapping.getOrDefault(vehicleNumber, null);
    }

    //get all parked vehicle
    public List<ParkedVehicle> getAllParkedVehicle(){
        ArrayList<ParkedVehicle> list = new ArrayList<>();
        for(Map.Entry<Integer, ParkedVehicle> entry : parkingSlotToVehicleMap.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }

}
