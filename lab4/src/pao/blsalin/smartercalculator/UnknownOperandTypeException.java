package pao.blsalin.smartercalculator;

import pao.blsalin.smartercalculator.CalculatorException;

public class UnknownOperandTypeException extends CalculatorException {
    public UnknownOperandTypeException(String operation) {
        super("Unknown operand type for: " + operation);
    }
}
