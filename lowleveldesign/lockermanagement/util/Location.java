package code.lowleveldesign.lockermanagement.util;

public class Location {

    int xCordinate;
    int yCordinate;

    public Location(int x, int y) {
        xCordinate = x;
        yCordinate = y;
    }

    public int getDistance(Location location){
        return 10;
    }

}
