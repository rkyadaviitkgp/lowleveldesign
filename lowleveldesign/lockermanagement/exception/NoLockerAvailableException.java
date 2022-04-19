package code.lowleveldesign.lockermanagement.exception;

public class NoLockerAvailableException extends Exception{
    public NoLockerAvailableException(String str){
        super(str);
    }
}
