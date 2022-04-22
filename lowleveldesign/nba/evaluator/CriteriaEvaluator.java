package code.lowleveldesign.nba.evaluator;

import code.lowleveldesign.nba.action.Action;
import code.lowleveldesign.nba.context.Context;
import code.lowleveldesign.nba.criteria.Criteria;

import java.util.List;

public interface CriteriaEvaluator {
    public boolean evaluate(Criteria criteria, Context context);
    public List<Action> getAction(Criteria criteria);
}
