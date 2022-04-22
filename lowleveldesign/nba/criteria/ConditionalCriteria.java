package code.lowleveldesign.nba.criteria;

import code.lowleveldesign.nba.action.Action;
import code.lowleveldesign.nba.context.Context;
import code.lowleveldesign.nba.criteria.operations.Operation;
import code.lowleveldesign.nba.criteria.operations.OperationResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConditionalCriteria implements Criteria {

    List<Action> actions;
    public static final CriteriaType criteriaType = CriteriaType.CONDITIONAL;
    HashMap<String, OperationResult> conditionKeyValue;

    public ConditionalCriteria(HashMap<String, OperationResult> keyValue) {
        this.conditionKeyValue = keyValue;
        actions = new ArrayList<Action>();
    }

    @Override
    public boolean isSatisfied(Context context) {
        HashMap<String, String> contextKeyValue = context.getContextKeyValue();
        for(String key : conditionKeyValue.keySet()){
            if(!contextKeyValue.containsKey(key))
                return false;
            String value = contextKeyValue.get(key);
            //System.out.println(value + " " + key);
            OperationResult operationResult = conditionKeyValue.get(key);
            Operation operation = operationResult.getOperation();
            if(!operation.runOperation(value, operationResult.getValue()))
                return false;
        }
        return true;
    }

    @Override
    public List<Action> getActions() {
        return actions;
    }

    @Override
    public boolean addAction(Action action) {
        actions.add(action);
        return true;
    }

    public void addNewCondition(String key, OperationResult operationResult){
        conditionKeyValue.put(key, operationResult);
    }
}
