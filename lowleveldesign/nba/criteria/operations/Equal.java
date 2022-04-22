package code.lowleveldesign.nba.criteria.operations;

public class Equal extends Operation{

    public boolean runOperation(String value1, String value2){
        if(value1.equals(value2))
            return true;
        return false;
    }

}
