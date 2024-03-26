package pao.blsalin.smartercalculator;

public class InvalidOperationException extends CalculatorException {
    public InvalidOperationException(String operation) {
        super("Invalid operation :" + operation);
    }
}