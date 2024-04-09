package task1;
import java.util.*;

public class Sorting {
    private List<Student> studenti;

    public Sorting(List<Student> studenti) {
        this.studenti = studenti;
    }

    public void sortareDupaNotaTotala(){
        studenti.sort(Comparator.comparingDouble(Student::calculNotaTotala).reversed());
        afisare("Sortare dupa cea mai mare nota totala", studenti);
    }

    public void sortareDupaPartial(){
        studenti.sort(Comparator.comparingDouble(Student::getNotaPartial).reversed());
        afisare("Sortare dupa cea mai mare nota la partial", studenti);
    }

    public void sortareDupaMedie(){
        studenti.sort(Comparator.comparingDouble(Student::calculMedie).reversed());
        afisare("Sortare dupa media notelor", studenti);
    }

    public void afisare(String string, List<Student> studenti){
        System.out.println(string);
        for (int i = 0; i < studenti.size(); i++) {
            Student student = studenti.get(i);
            System.out.printf("%d. %s %.2f %.2f %.2f\n", i + 1, student.getNume(), student.getNotaLaborator(),
                    student.getNotaPartial(), student.getNotaExamen());
        }
        System.out.println();
    }
}
