package code.lowleveldesign.parkinglot;

import java.time.LocalDateTime;
import java.util.HashMap;

//deals with creation of new ticket
public class TokenService {

    HashMap<String, Ticket> vehicleNumberToTicketMap;

    public TokenService() {
        vehicleNumberToTicketMap = new HashMap<>();
    }

    public void printBill(Ticket ticket){
        System.out.println("Your parking bill is " + ticket.amountCharged);
    }

    public Ticket getTicket(String vehicleNumber){
        return vehicleNumberToTicketMap.getOrDefault(vehicleNumber, null);
    }

    public Ticket createNewTicket(LocalDateTime issueTime, ParkedVehicle parkedVehicle){
        Ticket ticket = new Ticket(issueTime, parkedVehicle);
        vehicleNumberToTicketMap.put(parkedVehicle.getVehicleNumber(), ticket);
        return ticket;
    }

    public void checkoutTicket(Ticket ticket){
        vehicleNumberToTicketMap.remove(ticket.getParkedVehicle().getVehicleNumber());
        calculateAmount(ticket);
        ticket.setActive(false);
        ticket.setReleaseTime(LocalDateTime.now());
    }

    public void calculateAmount(Ticket ticket){
        ticket.setAmountCharged(100);
    }

}
