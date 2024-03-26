package pao.blsalin.smartercalculator;

public class InvalidArgumentsLengthException extends CalculatorRuntimeException {
    public InvalidArgumentsLengthException() {
        super("Invalid number of arguments");
    }
}