package code.lowleveldesign.parkinglot;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {

    String id;
    LocalDateTime issueTime;
    LocalDateTime releaseTime;
    ParkedVehicle parkedVehicle;
    boolean active;
    int amountCharged;

    public Ticket(LocalDateTime issueTime,  ParkedVehicle parkedVehicle) {
        id = UUID.randomUUID().toString();
        this.issueTime = issueTime;
        this.parkedVehicle = parkedVehicle;
        this.active = true;
        this.amountCharged = 0;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", issueTime=" + issueTime +
                ", releaseTime=" + releaseTime +
                ", parkedVehicle=" + parkedVehicle +
                ", active=" + active +
                ", amountCharged=" + amountCharged +
                '}';
    }

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(LocalDateTime issueTime) {
        this.issueTime = issueTime;
    }

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
    }

    public ParkedVehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(ParkedVehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public int getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(int amountCharged) {
        this.amountCharged = amountCharged;
    }
}
