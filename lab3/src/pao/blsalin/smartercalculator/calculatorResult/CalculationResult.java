package pao.blsalin.smartercalculator.calculatorResult;

import pao.blsalin.smartercalculator.CalculationRequest;

public abstract class CalculationResult {
    private final CalculationRequest request;

    public CalculationResult(CalculationRequest request) {
        this.request = request;
    }

    public CalculationRequest getRequest() {
        return request;
    }
    public abstract Object computeResult();
}
