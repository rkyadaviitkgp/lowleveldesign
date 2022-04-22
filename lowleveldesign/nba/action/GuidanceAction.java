package code.lowleveldesign.nba.action;

public class GuidanceAction implements Action{

    String guidanceMessage;
    ActionState state;
    public static final ActionType actionType = ActionType.GUIDANCE;

    public GuidanceAction(String guidanceMessage) {
        this.guidanceMessage = guidanceMessage;
        initializeAction();
    }

    @Override
    public void initializeAction() {
        state = ActionState.INITIALIZED;
    }

    @Override
    public void startAction() {
        state = ActionState.STARTED;
    }

    @Override
    public void completeAction() {
        System.out.println(guidanceMessage);
        state = ActionState.COMPLETED;
    }

    @Override
    public void cancelAction() {
        state = ActionState.CANCELLED;
    }

    @Override
    public ActionState getActionState(Action action) {
        return state;
    }
}
