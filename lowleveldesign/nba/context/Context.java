package code.lowleveldesign.nba.context;

import code.lowleveldesign.nba.exception.NoClassNameAttributeFound;
import code.lowleveldesign.nba.exception.NoKeyValuePairFound;

import java.util.HashMap;

public class Context {

    HashMap<String, String> contextKeyValue;
    public static final String className = "class";

    public Context() {
        contextKeyValue = new HashMap<String, String>();
    }

    public void addNewKeyValue(String key, String value){
        contextKeyValue.put(key, value);
    }

    public HashMap<String, String> getContextKeyValue() {
        return contextKeyValue;
    }

    public String getClassName() throws NoClassNameAttributeFound {
        if(!contextKeyValue.containsKey(className))
            new NoClassNameAttributeFound("No class name attribute is found in this context");
        return contextKeyValue.get(className);
    }

    public void addNewKeyValuePair(String key, String value){
        contextKeyValue.put(key, value);
    }

    public String getValueForKey(String key) throws NoKeyValuePairFound {
        if(!contextKeyValue.containsKey(key))
            new NoKeyValuePairFound("The value for key " + key + " is not found in this context object" );
        return contextKeyValue.get(key);
    }

    public void printkeyValuePair(){
        for(String key : contextKeyValue.keySet()){
            System.out.println(key + " " + contextKeyValue.get(key));
        }
    }

    public void setContextKeyValue(HashMap<String, String> contextKeyValue) {
        this.contextKeyValue = contextKeyValue;
    }

}
