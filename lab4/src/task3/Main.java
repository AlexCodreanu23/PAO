package task3;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Double> courseInfo = new HashMap<>();
        courseInfo.put("Math", 9.5);
        courseInfo.put("Physics", 5.5);

        Student student1 = new Student("Alex Codreanu ", courseInfo);
        System.out.println("student1: " + student1);
    }
}
