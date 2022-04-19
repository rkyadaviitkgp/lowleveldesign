package code.lowleveldesign.parkinglot;

import code.lowleveldesign.parkinglot.exceptions.NoParkingSlotAvailableException;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NearestParkingSlotChooseService implements ParkingSlotChoosingService {

    Queue<ParkingSlot> parkingSlotQueueSmall;
    Queue<ParkingSlot> parkingSlotQueueBig;
    Queue<ParkingSlot> parkingSlotQueueMedium;
    public NearestParkingSlotChooseService(List<ParkingSlot> list) {
        parkingSlotQueueSmall = new PriorityQueue<>((q1, q2) -> {
            return q1.slotNumber - q2.slotNumber;
        });
        parkingSlotQueueBig = new PriorityQueue<>((q1, q2) -> {
            return q1.slotNumber - q2.slotNumber;
        });
        parkingSlotQueueMedium = new PriorityQueue<>((q1, q2) -> {
            return q1.slotNumber - q2.slotNumber;
        });
        for(ParkingSlot parkingSlot : list){
            if(parkingSlot.slotType == ParkingSlotType.BIG)
                parkingSlotQueueBig.add(parkingSlot);
            else if(parkingSlot.slotType == ParkingSlotType.SMALL)
                parkingSlotQueueSmall.add(parkingSlot);
            else if(parkingSlot.slotType == ParkingSlotType.MEDIUM)
                parkingSlotQueueMedium.add(parkingSlot);

        }
    }

    @Override
    public ParkingSlot getNextSlot(ParkingSlotType type) throws NoParkingSlotAvailableException {
        if(type == ParkingSlotType.BIG){
            if(parkingSlotQueueBig.isEmpty())
                throw new NoParkingSlotAvailableException("No Parking Slot found exception ");
            return parkingSlotQueueBig.poll();
        }
        else if(type == ParkingSlotType.MEDIUM){
            if(parkingSlotQueueMedium.isEmpty())
            {
                if(parkingSlotQueueBig.isEmpty())
                    throw new NoParkingSlotAvailableException("No Parking Slot found exception ");
                return parkingSlotQueueBig.poll();
            }
            return parkingSlotQueueMedium.poll();
        }else if(type == ParkingSlotType.SMALL){
            if(parkingSlotQueueSmall.isEmpty())
            {
                if(parkingSlotQueueMedium.isEmpty())
                {
                    if(parkingSlotQueueBig.isEmpty())
                        throw new NoParkingSlotAvailableException("No Parking Slot found exception ");
                    return parkingSlotQueueBig.poll();
                }
                return parkingSlotQueueMedium.poll();
            }
            return parkingSlotQueueSmall.poll();
        }
        throw new NoParkingSlotAvailableException("No Parking Slot found exception ");
    }

    @Override
    public void addSlot(ParkingSlot parkingSlot) {
        parkingSlot.setAvailable(true);
        if(parkingSlot.slotType == ParkingSlotType.BIG)
            parkingSlotQueueBig.add(parkingSlot);
        else if(parkingSlot.slotType == ParkingSlotType.MEDIUM)
            parkingSlotQueueMedium.add(parkingSlot);
        else
            parkingSlotQueueSmall.add(parkingSlot);
    }


}
