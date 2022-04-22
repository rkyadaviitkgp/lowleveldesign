package code.lowleveldesign.nba.recommendation;

import code.lowleveldesign.nba.action.Action;
import code.lowleveldesign.nba.context.Context;
import code.lowleveldesign.nba.criteria.Criteria;
import code.lowleveldesign.nba.criteria.CriteriaType;
import code.lowleveldesign.nba.evaluator.ConditionalCriteriaEvaluator;
import code.lowleveldesign.nba.evaluator.EvaluatorFinder;
import code.lowleveldesign.nba.exception.NoClassNameAttributeFound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecommendationEngine {

    HashMap<String, List<Criteria>> criteriaListForContext;
    //EvaluatorFinder evaluatorFinder;


    public RecommendationEngine() {
        criteriaListForContext = new HashMap<>();
    }

    public List<Action> recommendAction(Context context){

        String className;
        List<Action> ans = new ArrayList<Action>();
        try {
            className = context.getClassName();
        }catch (NoClassNameAttributeFound noClassNameAttributeFound){
            System.out.println(noClassNameAttributeFound.getMessage());
            return ans;
        }

       if(!criteriaListForContext.containsKey(className)){
           System.out.println("No criteria is defined yet for this context in the system ");
           return ans;
       }

       List<Criteria> list = criteriaListForContext.get(className);

       for(Criteria criteria : list){
            if(criteria.isSatisfied(context))
                ans.addAll(criteria.getActions());
       }
       return ans;

    }


}
