package lab1.task2;

public class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
    public String getName(){
        return name;
    }

    public void setName(String name_){
        this.name = name_;
    }

    public double getGrade(){
        return grade;
    }

    public void setGrade(double grade_){
        this.grade = grade_;
    }


}
