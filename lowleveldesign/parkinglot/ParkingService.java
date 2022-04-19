package code.lowleveldesign.parkinglot;

import code.lowleveldesign.parkinglot.exceptions.NoParkingSlotAvailableException;

import java.util.List;

public class ParkingService {

    private ParkingInfoManager parkingInfoManager;
    private ParkingSlotChoosingService slotChooseService;

    public ParkingService(ParkingSlotChoosingService slotChoosingService) {
        this.parkingInfoManager = new ParkingInfoManager();
        this.slotChooseService = slotChoosingService;
    }

    // park a vehicle
    public ParkingInfo parkVehicle(ParkedVehicle parkedVehicle){
        try{

            ParkingSlot parkingSlot = slotChooseService.getNextSlot(parkedVehicle.getType().getParkingSpace(parkedVehicle.getType()));
            parkingSlot.setAvailable(false);
            ParkingInfo parkingInfo = new ParkingInfo(parkedVehicle, parkingSlot);
            parkingInfoManager.addParkingInfo(parkingInfo);
            return parkingInfo;
        }catch (NoParkingSlotAvailableException noParkingSlotAvailable){
            System.out.println("No slot/space available in parking system");
        }
        return null;
    }

    // remove vehicle from parking system
    public void unParkVehicle(String vehicleNumber){
        ParkingInfo parkingInfo = parkingInfoManager.getParkingInfo(vehicleNumber);
        ParkingSlot parkingSlot = parkingInfo.getParkingSlot();
        ParkedVehicle parkedVehicle = parkingInfo.getParkedVehicle();
        slotChooseService.addSlot(parkingSlot);
    }

    //get vehicle parked at slot number
    public ParkedVehicle getParkedVehicle(int slotId){
        ParkedVehicle parkedVehicle =  parkingInfoManager.getParkedVehicle(slotId);
        if(parkedVehicle == null){
            System.out.println(" No vehicle is parked at this spot "  );
        }
        return parkedVehicle;
    }

    //get slot number where vehicle xxx is parked
    public ParkingSlot getParkingSlot(String vehicleNumber){
        ParkingSlot parkingSlot =  parkingInfoManager.getParkingSlot(vehicleNumber);
        if(parkingSlot == null){
            System.out.println("Vehicle is not parked in any slot");
        }
        return parkingSlot;
    }

    //get parking info for vehicle number xxx
    public ParkingInfo getParkingInfo(String vehicleNumber){
        ParkingInfo parkingInfo =  parkingInfoManager.getParkingInfo(vehicleNumber);
        if(parkingInfo == null){
            System.out.println("No parking info is found for this vehicle number");
        }
        return parkingInfo;
    }

    //get all parked vehicle
    public List<ParkedVehicle> getAllParkedVehcile(){
        return parkingInfoManager.getAllParkedVehicle();
    }

}
