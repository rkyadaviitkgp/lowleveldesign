package code.lowleveldesign.parkinglot;

import java.time.LocalDateTime;
import java.util.List;

public class ParkingManager {

    TokenService tokenService;
    ParkingService parkingService;

    public ParkingManager(ParkingSlotChoosingService slotChooseService) {
        parkingService = new ParkingService(slotChooseService);
        tokenService = new TokenService();
    }

    //park a vehicle
    public void parkVehicle(ParkedVehicle parkedVehicle){
        ParkingInfo parkingInfo = parkingService.parkVehicle(parkedVehicle);
        //System.out.println(parkingInfo);
        tokenService.createNewTicket(LocalDateTime.now(),  parkedVehicle);
    }

    //un park a vehicle
    public void unParkVehicle(Ticket ticket){
        parkingService.unParkVehicle(ticket.getParkedVehicle().vehicleNumber);
        tokenService.checkoutTicket(ticket);
        tokenService.printBill(ticket);
    }

    // get vehicle at spot
    public ParkedVehicle getVehicleAtSpot(int spotId){
        return parkingService.getParkedVehicle(spotId);
    }

    //get spot of a vehicle
    public ParkingSlot getSlotOfVehicle(String vehicleNumber){
        return parkingService.getParkingSlot(vehicleNumber);
    }

    //get parking info for vehicle number
    public ParkingInfo getParkingInfo(String vehicleNumber){
        return parkingService.getParkingInfo(vehicleNumber);
    }

    // get ticket for vehicle
    public Ticket getTicket(String vehicleNumber){
        return tokenService.getTicket(vehicleNumber);
    }

    //get parking amount for ticket
    public double getAmount(String vehicleNumber){
        return tokenService.getTicket(vehicleNumber).getAmountCharged();
    }

    //get all parked vechile
    public List<ParkedVehicle> getAllParkedVehcile(){
        return parkingService.getAllParkedVehcile();
    }

}
