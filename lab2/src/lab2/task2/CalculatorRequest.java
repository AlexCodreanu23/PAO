package lab2.task2;

public class CalculatorRequest {
    private Object leftOperand;
    private Object rightOperand;
    private String operation;

    public Object getLeftOperand() {
        return leftOperand;
    }

    public Object getRightOperand() {
        return rightOperand;
    }

    public String getOperation() {
        return operation;
    }

    public CalculatorRequest(Object leftOperand, Object rightOperand, String operation) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = operation;
    }

    public String getRequestType(){
        if(leftOperand instanceof Boolean){
            return "Boolean";
        }
        else if(leftOperand instanceof Integer && rightOperand instanceof Integer){
            return "Integer";
        }
        else{
            return "Double";
        }
    }

    @Override
    public String toString(){
        return leftOperand.toString() + " " + operation + " " + rightOperand.toString();
    }

}
