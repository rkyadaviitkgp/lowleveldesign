package code.lowleveldesign.inmemoryfilesystem.exceptions;

public class NoSpaceAvailable extends Exception{
    public NoSpaceAvailable(String msg) {
        super(msg);
    }
}
