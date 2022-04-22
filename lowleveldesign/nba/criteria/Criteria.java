package code.lowleveldesign.nba.criteria;
import code.lowleveldesign.nba.action.Action;
import code.lowleveldesign.nba.context.Context;

import java.util.List;

public interface Criteria {
    //public CriteriaType criteriaType = CriteriaType.BASE;
    public boolean isSatisfied(Context context);
    public List<Action> getActions();
    public boolean addAction(Action action);
}
