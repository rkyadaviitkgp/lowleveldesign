package code.lowleveldesign.lockermanagement.locker;

import code.lowleveldesign.lockermanagement.otp.OTP;

import java.util.HashMap;
import java.util.UUID;

public class LockerUser {

    String id;
    String mailId;
    public String mobileNumber;
    HashMap<Integer, OTP> lockerToOTPMap;

    public LockerUser(String mailId, String mobileNumber) {
        id = UUID.randomUUID().toString();
        this.mailId = mailId;
        this.mobileNumber = mobileNumber;
        lockerToOTPMap = new HashMap<>();
    }

    public void putOTP(int lockerId, OTP otp){
        lockerToOTPMap.put(lockerId, otp);
    }

    public OTP getOTP(int lockerId){
        return lockerToOTPMap.get(lockerId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
