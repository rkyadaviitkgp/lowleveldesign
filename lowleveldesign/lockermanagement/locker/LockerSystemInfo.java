package code.lowleveldesign.lockermanagement.locker;

import code.lowleveldesign.lockermanagement.parcel.Parcel;

import java.util.HashMap;

public class LockerSystemInfo {

    HashMap<String, LockerInfo> parcelIdToLockerInfoMap;
    HashMap<Integer, LockerInfo> lockerIdToLockerInfoMap;

    public LockerSystemInfo() {
        parcelIdToLockerInfoMap = new HashMap<>();
        lockerIdToLockerInfoMap = new HashMap<>();
    }

    public boolean addNewLockerInfo(LockerInfo lockerInfo){
        parcelIdToLockerInfoMap.put(lockerInfo.getParcel().getId(), lockerInfo);
        lockerIdToLockerInfoMap.put(lockerInfo.getLocker().id, lockerInfo);
        return true;
    }

    public boolean removeLockerInfo(LockerInfo lockerInfo){
        parcelIdToLockerInfoMap.remove(lockerInfo.getParcel().getId());
        lockerIdToLockerInfoMap.remove(lockerInfo.getLocker().id);
        return true;
    }

    public HashMap<String, LockerInfo> getParcelIdToLockerInfoMap() {
        return parcelIdToLockerInfoMap;
    }

    public void setParcelIdToLockerInfoMap(HashMap<String, LockerInfo> parcelIdToLockerInfoMap) {
        this.parcelIdToLockerInfoMap = parcelIdToLockerInfoMap;
    }

    public HashMap<Integer, LockerInfo> getLockerIdToLockerInfoMap() {
        return lockerIdToLockerInfoMap;
    }

    public void setLockerIdToLockerInfoMap(HashMap<Integer, LockerInfo> lockerIdToLockerInfoMap) {
        this.lockerIdToLockerInfoMap = lockerIdToLockerInfoMap;
    }
}
