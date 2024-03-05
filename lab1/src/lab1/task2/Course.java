package lab1.task2;
import java.util.*;

public class Course {
    private String name;
    private double minimumGrade;
    private Student[] students;

    public Course(String name, double minimumGrade, Student[] students) {
        this.name = name;
        this.minimumGrade = minimumGrade;
        this.students = students;
    }
    public String getName(){
        return name;
    }

    public void setName(String name_){
        this.name = name_;
    }
    public double getMinimumGrade(){
        return minimumGrade;
    }

    public void setMinimumGrade(double minimumGrade_){
        this.minimumGrade = minimumGrade_;
    }

    public Student chooseStudentRandomly(){
        Random random = new Random();
        int randomIndex = random.nextInt(students.length);
        return students[randomIndex];
    }

    public Student[] showAllPassingStudents(){
        Student[] numberStudents = new Student[students.length];
        int index = 0;
        for(Student i : students){
            if(i.getGrade() >= minimumGrade){
                numberStudents[index] = i;
                index++;
            }
        }
        return numberStudents;
    }

    public boolean isStudentPassing(int index){
        if(index >= students.length){
            return false;
        }
        if(students[index].getGrade() >= minimumGrade){
            return true;
        }
        return false;
    }

    public boolean isStudentPassing(Student i){
        for(Student student : students)
            if (student.equals(i) && i.getGrade() >= minimumGrade) {
                return true;
            }
        return false;
    }

}
