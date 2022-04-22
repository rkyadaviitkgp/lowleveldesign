package code.lowleveldesign.nba.action;

public interface Action {
    public void initializeAction();
    public void startAction();
    public void completeAction();
    public void cancelAction();
    public ActionState getActionState(Action action);
}
