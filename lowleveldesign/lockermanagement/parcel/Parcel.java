package code.lowleveldesign.lockermanagement.parcel;

import code.lowleveldesign.lockermanagement.locker.LockerUser;

import java.util.UUID;

public class Parcel {

    String id;
    String orderId;
    ParcelType type;
    ParcelStatus status;
    LockerUser user;

    public Parcel(String orderId, ParcelType type, ParcelStatus status, LockerUser user) {
        id = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.type = type;
        this.status = status;
        this.user = user;
    }

    public LockerUser getUser() {
        return user;
    }

    public void setUser(LockerUser user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ParcelType getType() {
        return type;
    }

    public void setType(ParcelType type) {
        this.type = type;
    }

    public ParcelStatus getStatus() {
        return status;
    }

    public void setStatus(ParcelStatus status) {
        this.status = status;
    }
}
