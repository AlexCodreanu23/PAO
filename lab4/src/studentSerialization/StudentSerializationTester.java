package studentSerialization;

import studentSerialization.domain.Student;
import studentSerialization.serialization.StudentStorage;
import studentSerialization.utils.StudentGenerator;

import java.io.*;
import java.util.*;

import static studentSerialization.utils.FileUtils.openFileForReading;
import static studentSerialization.utils.FileUtils.openFileForWriting;

public final class StudentSerializationTester {

    private final StudentStorage storage;

    public StudentSerializationTester(StudentStorage storage) {
        this.storage = storage;
    }

    public void runTests() {
        try {
            testWithSingleStudent();
            testWithMultipleStudents();
        } catch (IOException e) {
            System.err.println("Something threw IOException:\n" + Arrays.toString(e.getStackTrace()));
        }
    }

    private void testWithSingleStudent() throws IOException {
        String filePath = "./singleStudent.out";
        List<Student> studentList = (new StudentGenerator()).generateStudents(1);
        String testName = "single student serialization/deserialization";

        runSerializationDeserializationTest(filePath, studentList, testName);
    }

    private void testWithMultipleStudents() throws IOException {
        String filePath = "./multipleStudents.out";
        List<Student> studentList = (new StudentGenerator()).generateStudents(10);
        String testName = "single student serialization/deserialization";

        runSerializationDeserializationTest(filePath, studentList, testName);
    }

    private void runSerializationDeserializationTest(String filePath, List<Student> studentList, String testName) throws IOException {
        writeStudentList(filePath, studentList);

        List<Student> studentsFromFile = readStudentList(filePath);

        if (studentList.equals(studentsFromFile)) {
            System.out.println("Passed test: " + testName + "!");
        } else {
            System.err.println("Failed test: " + testName + "!");
        }
    }

    private List<Student> readStudentList(String filePath) throws IOException {
        List<Student> studentsFromFile;
        try (InputStream fileIn = openFileForReading(filePath)) {
            studentsFromFile = storage.readAllStudents(fileIn);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return studentsFromFile;
    }

    private void writeStudentList(String filePath, List<Student> studentList) throws IOException {
        try (OutputStream fileOut = openFileForWriting(filePath)) {
            storage.writeAllStudents(fileOut, studentList);
        }
    }

}
