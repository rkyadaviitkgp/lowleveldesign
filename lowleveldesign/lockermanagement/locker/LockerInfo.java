package code.lowleveldesign.lockermanagement.locker;

import code.lowleveldesign.lockermanagement.parcel.Parcel;

import java.time.LocalDateTime;

public class LockerInfo {

    Locker locker;
    Parcel parcel;
    LocalDateTime time;

    public LockerInfo(Locker locker, Parcel parcel, LocalDateTime time) {
        this.locker = locker;
        this.parcel = parcel;
        this.time = time;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
