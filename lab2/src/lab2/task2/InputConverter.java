package lab2.task2;


import java.util.*;

public class InputConverter {

    public static List<CalculatorRequest> mapRequests(String[] args){
        List<CalculatorRequest> l = new ArrayList<>();
        for(String arg : args){
            String[] p = arg.split(" ");
            if(p.length == 3){
                Object leftOperand = p[0];
                Object rightOperand = p[2];
                String operation = p[1];
                l.add(new CalculatorRequest(leftOperand, rightOperand, operation));
            }
        }
        return l;
    }
}
