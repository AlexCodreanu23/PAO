package task6;

public class Main {
    public static void main(String[] args) {
        String filename = args[0];
        char c = args[1].charAt(0);
        CountChar cc = new CountChar(filename, c);
        cc.CountChar();
        int res = cc.getCount();
        System.out.println(res);
    }
}
