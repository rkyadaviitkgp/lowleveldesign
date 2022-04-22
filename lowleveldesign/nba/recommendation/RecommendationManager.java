package code.lowleveldesign.nba.recommendation;

import code.lowleveldesign.nba.action.Action;
import code.lowleveldesign.nba.context.Context;
import code.lowleveldesign.nba.criteria.Criteria;

import java.util.ArrayList;
import java.util.List;

public class RecommendationManager {

    RecommendationEngine recomendationEngine;

    public RecommendationManager() {
        recomendationEngine = new RecommendationEngine();
    }

    public List<Action> recommendedActions(Context context){
        return recomendationEngine.recommendAction(context);
    }

    public void addNewCriteria(String className, Criteria criteria){
        if(!recomendationEngine.criteriaListForContext.containsKey(className))
            recomendationEngine.criteriaListForContext.put(className, new ArrayList<Criteria>());
        recomendationEngine.criteriaListForContext.get(className).add(criteria);
    }

    public void addNewActionInCriteria(Criteria criteria, Action action){
        criteria.addAction(action);
    }

}
