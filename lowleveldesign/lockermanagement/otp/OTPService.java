package code.lowleveldesign.lockermanagement.otp;
import code.lowleveldesign.lockermanagement.locker.Locker;
import code.lowleveldesign.lockermanagement.locker.LockerUser;

import java.util.HashMap;

public class OTPService {

    HashMap<Integer, OTP> lockerToOTPMap;
    NotificationService notificationService;

    public OTPService() {
        lockerToOTPMap = new HashMap<>();
        notificationService = new NotificationService();
    }

    public OTP generateOTPForLocker(Locker locker){
        OTP otp = new OTP(locker);
        lockerToOTPMap.put(locker.getId(), otp);
        return otp;
    }

    public boolean verifyOTPForLocker(OTP otp, Locker locker){
        OTP fetchedOTP = lockerToOTPMap.get(locker.getId());
        if(otp.getOtp().equals(fetchedOTP.otp)){
            return true;
        }
        return false;
    }

    public boolean notifyUser(OTP otp, LockerUser lockerUser){
        lockerUser.putOTP(otp.getLocker().getId(), otp);
        notificationService.notifyUserByMessage(lockerUser.mobileNumber);
        return true;
    }

}
