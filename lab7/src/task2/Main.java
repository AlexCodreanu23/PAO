package task2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            File f = new File(".");
            System.out.println(f.getAbsolutePath());
            FileReader fileReader = new FileReader("./src/task2/input2.txt");
            BufferedReader buffer = new BufferedReader(fileReader);

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