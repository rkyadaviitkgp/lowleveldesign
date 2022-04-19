package code.lowleveldesign.lockermanagement.locker;

import code.lowleveldesign.lockermanagement.exception.NoLockerAvailableException;
import code.lowleveldesign.lockermanagement.otp.OTP;
import code.lowleveldesign.lockermanagement.parcel.Parcel;
import code.lowleveldesign.lockermanagement.parcel.ParcelType;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class LockerService {

    Queue<Locker> smallLocker;
    Queue<Locker> mediumLocker;
    Queue<Locker> bigLocker;
    LockerSystemInfo lockerSystemInfo;
    HashMap<Integer, Locker> lockerIdToLockerMap;


    public LockerService(List<Locker> list) {

        smallLocker = new LinkedList<>();
        mediumLocker = new LinkedList<>();
        bigLocker = new LinkedList<>();
        lockerSystemInfo =  new LockerSystemInfo();
        lockerIdToLockerMap = new HashMap<>();

        for(Locker locker : list){
            addLocker(locker);
            lockerIdToLockerMap.put(locker.getId(), locker);
        }
    }

    private void addLocker(Locker locker){
        if(locker.type == LockerType.BIG)
            bigLocker.add(locker);
        else if(locker.type == LockerType.MEDIUM)
            mediumLocker.add(locker);
        else
            smallLocker.add(locker);
    }

    private Locker getAvailableLocker(ParcelType type){
        try{
            if(type == ParcelType.BIG){
                if(bigLocker.isEmpty())
                    throw new NoLockerAvailableException("No big Locker available");
                return bigLocker.poll();
            }else if(type == ParcelType.MDEIUM){
                if(mediumLocker.isEmpty()){
                    if(bigLocker.isEmpty())
                        throw new NoLockerAvailableException("No Medium/big Locker available");
                    return bigLocker.poll();
                }
                return mediumLocker.poll();
            }else{
                if(smallLocker.isEmpty()){
                    if(mediumLocker.isEmpty()){
                        if(bigLocker.isEmpty())
                            throw new NoLockerAvailableException("No Medium/big Locker available");
                        return bigLocker.poll();
                    }
                    return mediumLocker.poll();
                }
                return smallLocker.poll();
            }
        }catch (NoLockerAvailableException exception){
            System.out.println(exception);
        }
       return null;
    }

    // delivery boy
    public int keepParcel(Parcel parcel){
        Locker locker = getAvailableLocker(parcel.getType());
        if(locker == null)
        {
            return -1;
        }
        LockerInfo lockerInfo = new LockerInfo(locker, parcel, LocalDateTime.now());
        locker.setAvailable(false);
        lockerSystemInfo.addNewLockerInfo(lockerInfo);

        return lockerInfo.getLocker().getId();
    }

    // open locker and receive parcel
    public Parcel receiveParcel(Locker locker){
        locker.setAvailable(true);
        LockerInfo lockerInfo = lockerSystemInfo.getLockerIdToLockerInfoMap().get(locker.id);
        lockerSystemInfo.removeLockerInfo(lockerInfo);
        addLocker(locker);
        return lockerInfo.getParcel();
    }

    public Locker getLockerIdToLockerObject(int id) {
        return lockerIdToLockerMap.get(id);
    }

}
