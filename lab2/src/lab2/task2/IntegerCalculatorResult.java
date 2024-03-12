package lab2.task2;


public class IntegerCalculatorResult extends CalculatorResult {
    public IntegerCalculatorResult(CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }

    @Override
    public Object  computeResult(){
        int left = (int) getRequest().getLeftOperand();
        int right = (int) getRequest().getRightOperand();
        String operation = getRequest().getOperation();
        switch(operation){
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                return null;
        }
    }

}
