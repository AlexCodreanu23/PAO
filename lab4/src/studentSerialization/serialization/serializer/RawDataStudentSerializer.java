package studentSerialization.serialization.serializer;

import studentSerialization.domain.Student;

import java.io.*;

public final class RawDataStudentSerializer implements StudentSerializer {
    @Override
    public void serialize(OutputStream os, Student student) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(student);
    }
}
