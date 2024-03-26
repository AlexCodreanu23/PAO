package studentSerialization.serialization.serializer;

import studentSerialization.domain.Student;

import java.io.*;

public interface StudentSerializer {
    void serialize(OutputStream os, Student student) throws IOException;
}
