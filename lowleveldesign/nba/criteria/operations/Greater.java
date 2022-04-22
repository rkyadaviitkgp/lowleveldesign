package code.lowleveldesign.nba.criteria.operations;

public class Greater extends Operation{

    public boolean runOperation(String str1, String str2){
        if(str1.compareTo(str2) > 0)
            return true;
        return false;
    }

}
