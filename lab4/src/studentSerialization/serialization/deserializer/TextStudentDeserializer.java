package studentSerialization.serialization.deserializer;

import studentSerialization.domain.Student;

import java.io.*;

public class TextStudentDeserializer implements StudentDeserializer {

    @Override
    public Student deserialize(InputStream inputStream) throws IOException, ClassNotFoundException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String studentData = reader.readLine();
            return new Student(studentData);
        }
    }
}