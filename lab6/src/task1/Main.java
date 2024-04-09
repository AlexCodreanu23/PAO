package task1;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student("student1", 59.2, 73.9, 97.1));
        studenti.add(new Student("student2", 38.7, 89.9, 76.8));
        studenti.add(new Student("student3", 51.9, 90.0, 68.8));

        Sorting s = new Sorting(studenti);

        s.sortareDupaNotaTotala();
        s.sortareDupaPartial();
        s.sortareDupaMedie();
    }
}