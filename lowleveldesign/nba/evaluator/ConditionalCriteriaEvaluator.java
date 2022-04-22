package code.lowleveldesign.nba.evaluator;

import code.lowleveldesign.nba.action.Action;
import code.lowleveldesign.nba.context.Context;
import code.lowleveldesign.nba.criteria.ConditionalCriteria;
import code.lowleveldesign.nba.criteria.Criteria;

import java.util.List;

public class ConditionalCriteriaEvaluator implements CriteriaEvaluator {


    public ConditionalCriteriaEvaluator() {

    }

    @Override
    public boolean evaluate(Criteria criteria, Context context) {
        ConditionalCriteria conditionalCriteria = (ConditionalCriteria) criteria;
        return conditionalCriteria.isSatisfied(context);
    }

    public List<Action> getAction(Criteria criteria){
        ConditionalCriteria conditionalCriteria = (ConditionalCriteria) criteria;
        return conditionalCriteria.getActions();
    }


}
