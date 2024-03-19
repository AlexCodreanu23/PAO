package pao.blsalin.smartercalculator.calculatorResult;

import pao.blsalin.smartercalculator.CalculationRequest;

public final class BooleanCalculationResult extends CalculationResult {
    public BooleanCalculationResult(CalculationRequest request) {
        super(request);
    }

    @Override
    public Object computeResult() {
        CalculationRequest request = getRequest();
        Boolean leftOperand = (Boolean) request.leftOperand();
        Boolean rightOperand = (Boolean) request.rightOperand();

        return switch (request.operation()) {
            case "&&" -> leftOperand && rightOperand;
            case "||" -> leftOperand || rightOperand;
            default -> throw new IllegalArgumentException();
        };
    }
}
