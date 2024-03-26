package studentSerialization.serialization;

import studentSerialization.domain.Student;
import studentSerialization.serialization.deserializer.StudentDeserializer;
import studentSerialization.serialization.serializer.StudentSerializer;

import java.util.*;
import java.io.*;

public class StudentStorage {
    private final StudentSerializer serializer;
    private final StudentDeserializer deserializer;

    public StudentStorage(StudentSerializer serializer, StudentDeserializer deserializer) {
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    public void writeAllStudents(OutputStream os, List<Student> students) throws IOException {
        for (Student student : students) {
            serializer.serialize(os, student);
        }
    }

    public List<Student> readAllStudents(InputStream is) throws IOException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        boolean eof = false;

        while (!eof) {
            try {
                Student student = deserializer.deserialize(is);
                students.add(student);
            } catch (EOFException e) {
                eof = true;
            }
        }

        return students;
    }
}