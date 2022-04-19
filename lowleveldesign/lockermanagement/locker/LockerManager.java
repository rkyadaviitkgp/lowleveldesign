package code.lowleveldesign.lockermanagement.locker;
import code.lowleveldesign.lockermanagement.otp.OTP;
import code.lowleveldesign.lockermanagement.util.Location;
import code.lowleveldesign.lockermanagement.otp.OTPService;
import code.lowleveldesign.lockermanagement.parcel.Parcel;
import java.util.List;
import java.util.UUID;

public class LockerManager {

    String id;
    List<Locker> lockerList;
    Location location;
    LockerService lockerService;
    OTPService otpService;

    public LockerManager(List<Locker> lockerList, Location location) {
        id = UUID.randomUUID().toString();
        this.lockerList = lockerList;
        this.location = location;
        lockerService = new LockerService(lockerList);
        otpService = new OTPService();
    }

    // keep a parcel
    public Locker keepParcel(Parcel parcel){
        int lockerId = lockerService.keepParcel(parcel);
        if(lockerId == -1)
        {
            System.out.println("Can not put parcel");
            return null;
        }
        Locker locker = lockerService.getLockerIdToLockerObject(lockerId);
        OTP otp = generateOTPForLocker(locker);
        sendOTP(otp, parcel.getUser());
        System.out.println("Parcel " + parcel.getId() + " is kept in locker " + lockerId + " OTP is generated successfully " + otp.getOtp());
        return locker;
    }

    // receive a parcel
    public Parcel openLocker(OTP otp, Locker locker){
        // challenge otp
        boolean challenged = otpService.verifyOTPForLocker(otp, locker);
        Parcel parcel = lockerService.receiveParcel(locker);
        System.out.println("Parcel " + parcel.getId() + " is successfully received from locker " + locker.getId() + " using OTP  " + otp.getOtp());
        return parcel;
    }

    // generate otp
    public OTP generateOTPForLocker(Locker locker){
        OTP otp = otpService.generateOTPForLocker(locker);
        return otp;
    }

    // send otp to user
    public boolean sendOTP(OTP otp, LockerUser lockerUser){
        otpService.notifyUser(otp, lockerUser);
        return true;
    }

}
