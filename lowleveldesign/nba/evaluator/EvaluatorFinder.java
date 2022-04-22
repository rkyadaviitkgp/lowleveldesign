package code.lowleveldesign.nba.evaluator;

import code.lowleveldesign.nba.criteria.CriteriaType;

import java.util.HashMap;

public class EvaluatorFinder {
    private static HashMap<CriteriaType, CriteriaEvaluator> criteriaEvaluatorFinder;
    static{
        criteriaEvaluatorFinder.put(CriteriaType.CONDITIONAL, new ConditionalCriteriaEvaluator());
    }

    public CriteriaEvaluator getEvaluator(CriteriaType criteriaType){
        return criteriaEvaluatorFinder.get(criteriaType);
    }

}
