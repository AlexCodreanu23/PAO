package task1;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./src/task1/input.txt");
            Scanner scanner = new Scanner(fis);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                break;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}