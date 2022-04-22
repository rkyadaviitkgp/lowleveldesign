package code.lowleveldesign.nba.criteria.operations;

public class Contains extends Operation{
    public boolean runOperation(String value1, String value2){
        //System.out.println(value1 + " " + value2);
        if(value1.contains(value2))
            return true;
        return false;
    }
}
