package lab2.task2;


public class BooleanCalculatorResult extends CalculatorResult {
    public BooleanCalculatorResult(CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }

    @Override
    public Object  computeResult(){
        Boolean left = (Boolean) getRequest().getLeftOperand();
        Boolean right = (Boolean) getRequest().getRightOperand();
        String operation = getRequest().getOperation();
        switch(operation){
            case "&&":
                return left && right;
            case "||":
                return left || right;
            default:
                return null;
        }
    }

}
