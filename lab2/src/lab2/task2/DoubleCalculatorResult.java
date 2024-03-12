package lab2.task2;


public class DoubleCalculatorResult extends CalculatorResult {
    public DoubleCalculatorResult(CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }

    @Override
    public Object  computeResult(){
        double left = (double) getRequest().getLeftOperand();
        double right = (double) getRequest().getRightOperand();
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
