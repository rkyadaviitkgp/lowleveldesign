package code.lowleveldesign.nba.context;
import java.util.HashMap;

public class ContextGenerator {

    Context context;

    public ContextGenerator(String className) {
        context = new Context();
        context.addNewKeyValue("class", className);
    }

    public void populateAttributes(HashMap<String, String> contextKeyValue){
        for(String key : contextKeyValue.keySet()){
            context.addNewKeyValue(key, contextKeyValue.get(key));
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
