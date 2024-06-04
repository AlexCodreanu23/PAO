package task5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Bilants> list = new ArrayList<>();
        list.add(new Bilants(5,-1));
        list.add(new Bilants(7,-2));
        list.add(new Bilants(5,-9));
        List<Bilants> sortedL = list.stream().sorted().collect(Collectors.toList());

        for(Bilants b : sortedL){
            System.out.println(b);
        }
    }
}
