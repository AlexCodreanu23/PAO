package task1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream f = new FileInputStream("./src/task1/input.txt");
            InputStreamReader isr = new InputStreamReader(f);
            BufferedReader buffer = new BufferedReader(isr);

            String s1 = buffer.readLine();
            String s2 = buffer.readLine();

            System.out.println(s2);
            buffer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}