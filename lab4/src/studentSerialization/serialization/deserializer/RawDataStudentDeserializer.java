package studentSerialization.serialization.deserializer;

import studentSerialization.domain.Student;

import java.io.*;

public final class RawDataStudentDeserializer implements StudentDeserializer {
    @Override
    public Student deserialize(InputStream is) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(is);
        return (Student) ois.readObject();
    }
}
