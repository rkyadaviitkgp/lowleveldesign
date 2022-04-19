package code.lowleveldesign.parkinglot;

import code.lowleveldesign.parkinglot.conditions.QueryCondition;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingSystem {

    List<ParkingSlot> parkingSlotList;
    ParkingManager parkingManager;

    public ParkingSystem(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
        ParkingSlotChoosingService parkingSlotChoosingService = new NearestParkingSlotChooseService(parkingSlotList);
        parkingManager = new ParkingManager(parkingSlotChoosingService);
    }

    //park a vehicle and return parking ticket
    public void parkVehicle(String vehicleNumber, VehicleType type, VehicleColour colour){
        ParkedVehicle parkedVehicle = new ParkedVehicle(vehicleNumber, colour, type);
        parkingManager.parkVehicle(parkedVehicle);
    }

    // generate ticket for parked vehicle
    public Ticket generateTicket(String vehicleNumber){
        Ticket ticket = parkingManager.getTicket(vehicleNumber);
        if(ticket == null){
            System.out.println("Ticket is not created  for this vehicle");
        }else{
            System.out.println(ticket);
        }
        return ticket;
    }

    //remove a vehicle from parking and update system
    public void unParkVehicle(Ticket ticket){
        parkingManager.unParkVehicle(ticket);
    }

    // get fee amount for parking
    // call this method before unparking
    public double getParkingAmount(String vehicleNumber){
       return parkingManager.getAmount(vehicleNumber);
    }

    //add a new spot in parking system
    public void addSpot(ParkingSlot parkingSlot){
        //todo
    }

    //remove a spot from parking system
    public void removeSpot(int spottId){
        //todo
    }

    // get spot for vehicle
    public int  getSpotNumber(String vehicleNumber){
        //System.out.println(parkingManager.getSlotOfVehicle(vehicleNumber));
        return parkingManager.getSlotOfVehicle(vehicleNumber).slotNumber;
    }

    //get all vehicle staisfying condition
    public List<ParkedVehicle> getParkedVehicleSatisfyingCondition(QueryCondition queryCondition){
        ArrayList<ParkedVehicle> arrayList ;
        ArrayList<ParkedVehicle> ans = new ArrayList<>();
        arrayList = (ArrayList<ParkedVehicle>) parkingManager.getAllParkedVehcile();
        for(ParkedVehicle parkedVehicle : arrayList){
            if(queryCondition.isSatisfied(parkedVehicle))
                ans.add(parkedVehicle);
        }
        return ans;
    }

    //payment processing
    //todo


    //print parking info
    public void printParkingSpace(){
        //System.out.println("called");
        for(int i=0; i<parkingSlotList.size(); i++){
            if(parkingSlotList.get(i).isAvailable)
                System.out.println(parkingSlotList.get(i) + "     ");
            else
            {
                System.out.println(parkingManager.getVehicleAtSpot(parkingSlotList.get(i).getSlotNumber()) + "     ");
            }
        }
    }

    //print parking spot content
    private String printSpot(ParkingSlot parkingSlot){
        return "content";
    }

}
