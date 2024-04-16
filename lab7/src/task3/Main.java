package task3;

import java.io.*;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        for(int i = 1; i <= 10;i++){
            String name = "fisier_" + i + ".txt";
            try(FileWriter wr = new FileWriter(name)){
                LocalDateTime currentTime = LocalDateTime.now();
                wr.write("Index" + i + "\n");
                wr.write(String.valueOf(currentTime));
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}