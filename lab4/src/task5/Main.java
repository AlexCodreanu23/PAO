package task5;

public class Main {
    public static void main(String[] args) {
        bar();
    }
    public static void bar() {
        try {
            throw new ClassCastException();
        }
        catch (ClassCastException e){
            System.out.println(1);
        }
        catch (RuntimeException e) {
            System.out.println("fail");
        }
    }
}

