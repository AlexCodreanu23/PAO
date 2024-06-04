package task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountChar {
    private String filename;
    private char c;
    private int count;

    public CountChar(String filename, char c){
        this.filename = filename;
        this.c = c;
        this.count = 0;
    }

    public void CountChar() {
        List<Thread> threads = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                String linie2 = linie;
                Thread thread = new Thread(() -> function(linie2));
                threads.add(thread);
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Thread t : threads){
            try{
                t.join();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void function(String linie){
        for(char ch : linie.toCharArray()){
            if(ch == c){
                count ++;
            }
        }
    }

    public int getCount() {
        return count;
    }
}
