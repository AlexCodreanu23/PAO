package lab2.task2;

import java.util.*;

public class SmarterCalculator {
    public static List<CalculatorResult>calculate (String args[]){
        List<CalculatorRequest> input = InputConverter.mapRequests(args);
        List<CalculatorResult> res = new ArrayList<>();
        for(CalculatorRequest i : input){
            if(i.getRequestType().equals("Boolean")){
                res.add(new BooleanCalculatorResult(i));
            }
            else if(i.getRequestType().equals("Integer")){
                res.add(new IntegerCalculatorResult(i));
            }
            else if(i.getRequestType().equals("Double")){
                res.add(new DoubleCalculatorResult(i));
            }
        }
        return res;
    }


}
