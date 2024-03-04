package lab1.task4;

public class DummyCalculator {

    public void calculate(String[] args) {
        Object arg1 = parseValue(args[0]);
        String op = args[1];
        Object arg2 = parseValue(args[2]);

        if (arg1 instanceof Boolean) {
            boolean bool1 = (boolean) arg1;
            boolean bool2 = (boolean) arg2;
            if (op.equals("&&")) {
                System.out.println(bool1 && bool2);
            } else {
                System.out.println(bool1 || bool2);
            }
        } else if(arg1 instanceof Integer && arg2 instanceof Integer) {
            int num1 = (int) arg1;
            int num2 = (int) arg2;
            if(op.equals("+")){
                System.out.println(num1 + num2);
            }
            else if(op.equals("-")){
                System.out.println(num1 - num2);
            }
            else if(op.equals("*")){
                System.out.println(num1 * num2);
            }
            else{
                System.out.println(num1 / num2);
            }
        }
        else if(arg1 instanceof Integer && arg2 instanceof Double) {
            int num1 = (int) arg1;
            double num2 = (double) arg2;
            if(op.equals("+")){
                System.out.println(num1 + num2);
            }
            else if(op.equals("-")){
                System.out.println(num1 - num2);
            }
            else if(op.equals("*")){
                System.out.println(num1 * num2);
            }
            else{
                System.out.println(num1 / num2);
            }
        }
        else if(arg1 instanceof Double && arg2 instanceof Integer) {
            double num1 = (double) arg1;
            int num2 = (int) arg2;
            if(op.equals("+")){
                System.out.println(num1 + num2);
            }
            else if(op.equals("-")){
                System.out.println(num1 - num2);
            }
            else if(op.equals("*")){
                System.out.println(num1 * num2);
            }
            else{
                System.out.println(num1 / num2);
            }
        }
        else if(arg1 instanceof Double && arg2 instanceof Double) {
            double num1 = (double) arg1;
            double num2 = (double) arg2;
            if(op.equals("+")){
                System.out.println(num1 + num2);
            }
            else if(op.equals("-")){
                System.out.println(num1 - num2);
            }
            else if(op.equals("*")){
                System.out.println(num1 * num2);
            }
            else{
                System.out.println(num1 / num2);
            }
        }

    }
    private Object parseValue(String arg) {
        if(arg.equalsIgnoreCase("true")  || arg.equalsIgnoreCase("false")){
            return Boolean.parseBoolean(arg);
        }
        else if(arg.contains(".")){
            return Double.parseDouble(arg);
        }
        else{
            return Integer.parseInt(arg);
        }
    }
}
