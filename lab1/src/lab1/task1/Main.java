package lab1.task1;
import lab1.task2.StudentAllocator;
import lab1.task2.Student;
import lab1.task4.DummyCalculator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Student[] studenti = StudentAllocator.createStudents();
        for (Student student : studenti) {
            System.out.println("Name: " + student.getName() + ", Grade: " + student.getGrade());
        }

        DummyCalculator calculator = new DummyCalculator();
        String[] input = {"2", "*", "3.0"};
        calculator.calculate(input);
    }
}