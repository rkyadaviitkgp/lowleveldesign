package code.lowleveldesign.lockermanagement.otp;

import code.lowleveldesign.lockermanagement.locker.Locker;
import code.lowleveldesign.lockermanagement.locker.LockerUser;

import java.time.LocalDateTime;
import java.util.UUID;

public class OTP {

    String otp;
    LocalDateTime generationTime;
    LocalDateTime expiryTime;
    Locker locker;
    boolean isActive;

    public OTP( Locker locker) {
        otp = UUID.randomUUID().toString().substring(0,6);
        generationTime = LocalDateTime.now();
        this.expiryTime = LocalDateTime.now().plusSeconds(1800);
        this.locker = locker;
        isActive = true;
    }

    public OTP() {
        otp = UUID.randomUUID().toString().substring(0,6);
        generationTime = LocalDateTime.now();
        this.expiryTime = LocalDateTime.now().plusSeconds(1800);
        this.locker = null;
        isActive = true;
    }

    public String getOtp() {
        return otp;
    }

    public LocalDateTime getGenerationTime() {
        return generationTime;
    }

    public void setGenerationTime(LocalDateTime generationTime) {
        this.generationTime = generationTime;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
