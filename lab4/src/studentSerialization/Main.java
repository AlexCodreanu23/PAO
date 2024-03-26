package studentSerialization;

import studentSerialization.domain.Student;
import studentSerialization.serialization.StudentStorage;
import studentSerialization.serialization.deserializer.RawDataStudentDeserializer;
import studentSerialization.serialization.deserializer.TextStudentDeserializer;
import studentSerialization.serialization.serializer.RawDataStudentSerializer;
import studentSerialization.serialization.serializer.TextStudentSerializer;

import java.util.*;
import java.io.*;

public class Main {

    private final static boolean runBonus = false;

    public static void main(String[] args) {
        StudentStorage storage;
        if (runBonus) {
            storage = getStorageForBonus();
        } else {
            storage = getStorageForTask6();
        }

        StudentSerializationTester tester = new StudentSerializationTester(storage);
        tester.runTests();

        runCustomTests(storage);
    }

    private static void runCustomTests(StudentStorage storage) {

    }

    private static StudentStorage getStorageForTask6() {
        return new StudentStorage(new RawDataStudentSerializer(), new RawDataStudentDeserializer());
    }

    private static StudentStorage getStorageForBonus() {
        return new StudentStorage(new TextStudentSerializer(), new TextStudentDeserializer());
    }
}
