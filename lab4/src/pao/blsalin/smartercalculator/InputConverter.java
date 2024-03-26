package pao.blsalin.smartercalculator;
import pao.blsalin.smartercalculator.UnknownOperandTypeException;
import pao.blsalin.smartercalculator.requestMapper.BooleanCalculatorRequestMapper;
import pao.blsalin.smartercalculator.requestMapper.CalculatorRequestMapper;
import pao.blsalin.smartercalculator.requestMapper.DoubleCalculatorRequestMapper;
import pao.blsalin.smartercalculator.requestMapper.IntegerCalculatorRequestMapper;

import java.util.*;

public class InputConverter {

    private static final List<CalculatorRequestMapper> MAPPERS = Arrays.asList(new BooleanCalculatorRequestMapper(), new IntegerCalculatorRequestMapper(), new DoubleCalculatorRequestMapper());

    public static List<CalculationRequest> mapRequests(String[] args) throws InvalidArgumentsLengthException {
        if (args.length < 3 || args.length % 3 != 0) {
            throw new InvalidArgumentsLengthException();
        }

        List<CalculationRequest> calculatorRequests = new ArrayList<>();

        for (int i = 0; i < args.length; i += 3) {
            try {
                CalculationRequest request = mapRequest(args[i], args[i + 1], args[i + 2]);
                calculatorRequests.add(request);
            } catch (UnknownOperandTypeException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        return calculatorRequests;
    }

    private static CalculationRequest mapRequest(
            String leftOperandString,
            String operatorString,
            String rightOperandString) throws UnknownOperandTypeException {
        for (CalculatorRequestMapper mapper : MAPPERS) {
            Optional<CalculationRequest> calculatorRequestOptional = mapper.tryMapRequest(leftOperandString, operatorString, rightOperandString);
            if (calculatorRequestOptional.isPresent()) {
                return calculatorRequestOptional.get();
            }
        }
        throw new UnknownOperandTypeException("Unknown operand type for operation: " + operatorString);
    }
}
