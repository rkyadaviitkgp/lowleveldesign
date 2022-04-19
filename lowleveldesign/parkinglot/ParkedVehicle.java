package code.lowleveldesign.parkinglot;

public class ParkedVehicle {

    String vehicleNumber;
    VehicleColour colour;
    VehicleType type;

    public ParkedVehicle(String vehicleNumber, VehicleColour colour, VehicleType type) {
        this.vehicleNumber = vehicleNumber;
        this.colour = colour;
        this.type = type;
    }

    @Override
    public String toString() {
        return "ParkedVehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", colour=" + colour +
                ", type=" + type +
                '}';
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleColour getColour() {
        return colour;
    }

    public void setColour(VehicleColour colour) {
        this.colour = colour;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
