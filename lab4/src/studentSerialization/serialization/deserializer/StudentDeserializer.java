package studentSerialization.serialization.deserializer;

import studentSerialization.domain.Student;

import java.io.*;

public interface StudentDeserializer {
    Student deserialize(InputStream is) throws IOException, ClassNotFoundException;
}
