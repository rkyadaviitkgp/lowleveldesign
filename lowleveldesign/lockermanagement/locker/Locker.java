package code.lowleveldesign.lockermanagement.locker;

public class Locker {

    int id;
    LockerType type;
    boolean isAvailable;

    public Locker(int id, LockerType type, boolean isAvailable) {
        this.id = id;
        this.type = type;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public LockerType getType() {
        return type;
    }

    public void setType(LockerType type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
