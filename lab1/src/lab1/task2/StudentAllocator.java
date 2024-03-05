package lab1.task2;

public class StudentAllocator {

    public static Student[] createStudents(){
        Student[] checkStudents = new Student[5];

        for(int i = 0; i < 5;i++){
            String nume = "Student" + i;
            double grade = 5 + (i * 0.2);
            Student student = new Student("Student" + i, grade);
            checkStudents[i] = student;
        }
        return checkStudents;
    }
}
