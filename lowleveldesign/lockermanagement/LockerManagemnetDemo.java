package code.lowleveldesign.lockermanagement;

import code.lowleveldesign.lockermanagement.locker.Locker;
import code.lowleveldesign.lockermanagement.locker.LockerManager;
import code.lowleveldesign.lockermanagement.locker.LockerType;
import code.lowleveldesign.lockermanagement.locker.LockerUser;
import code.lowleveldesign.lockermanagement.parcel.Parcel;
import code.lowleveldesign.lockermanagement.parcel.ParcelStatus;
import code.lowleveldesign.lockermanagement.parcel.ParcelType;
import code.lowleveldesign.lockermanagement.util.Location;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class LockerManagemnetDemo {

    LockerManager lockerManager;

    public static void main(String[] args) {

        LockerUser lockerUser = new LockerUser("rkyadav.iitkgp@gmail.com", "9902543838");
        Parcel parcel = new Parcel("123", ParcelType.MDEIUM, ParcelStatus.DISPATCHED, lockerUser);
        ArrayList<Locker> lockers = new ArrayList<>();
        for(int i=0; i<10; i++){
            Locker locker = new Locker(i, LockerType.BIG, true);
            lockers.add(locker);
        }
        LockerManager lockerManager = new LockerManager(lockers, new Location(1,2));
        Locker locker = lockerManager.keepParcel(parcel);
        lockerManager.openLocker(lockerUser.getOTP(0), locker);
    }
}
