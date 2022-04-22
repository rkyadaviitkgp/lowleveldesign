package code.lowleveldesign.nba.criteria.operations;

public class OperationResult {

    String value;
    Operation operation;

    public OperationResult(String value, Operation operation) {
        this.value = value;
        this.operation = operation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
