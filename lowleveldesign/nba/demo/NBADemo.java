package code.lowleveldesign.nba.demo;

import code.lowleveldesign.nba.action.Action;
import code.lowleveldesign.nba.action.GuidanceAction;
import code.lowleveldesign.nba.context.Context;
import code.lowleveldesign.nba.criteria.ConditionalCriteria;
import code.lowleveldesign.nba.criteria.operations.Contains;
import code.lowleveldesign.nba.criteria.operations.Greater;
import code.lowleveldesign.nba.criteria.operations.OperationResult;
import code.lowleveldesign.nba.recommendation.RecommendationManager;

import java.util.HashMap;
import java.util.List;


public class NBADemo {

    public static void main(String[] args) {

        RecommendationManager recommendationManager = new RecommendationManager();

        GuidanceAction guidanceAction1 = new GuidanceAction("Guidance action 1");
        GuidanceAction guidanceAction2 = new GuidanceAction("Guidance action 2");
        GuidanceAction guidanceAction3 = new GuidanceAction("Guidance action 3");
        GuidanceAction guidanceAction4 = new GuidanceAction("Guidance action 4");

        HashMap<String, OperationResult> hm = new HashMap<>();
        hm.put("userName", new OperationResult("raj", new Contains()));
        hm.put("address", new OperationResult("Burnpur", new Contains()));
        hm.put("salary", new OperationResult("100", new Greater()));

        ConditionalCriteria conditionalCriteria = new ConditionalCriteria(hm);
        conditionalCriteria.addAction(guidanceAction1);
        conditionalCriteria.addAction(guidanceAction2);

        recommendationManager.addNewCriteria("User", conditionalCriteria);


        User rajeshUser = new User("rajesh", "Burnpur", 10000, "1", "servicenow");
        User rameshUser = new User("Ramesh", "Burnpur", 100000, "2", "Oracle");
        User ajitUser = new User("Ajit", "Fatuha", 10000, "3", "HP");
        User abhijitUser = new User("Abhijit", "Sitamarhi", 10000, "4", "TCS");
        Context rajeshContext = new Context();
        rajeshContext.setContextKeyValue(rajeshUser.getKeyValue());
        //rajeshContext.printkeyValuePair();

        List<Action> ans = recommendationManager.recommendedActions(rajeshContext);
        for(Action action : ans){
            action.completeAction();
        }

    }
}
