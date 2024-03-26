package studentSerialization.utils;

import java.io.*;
import java.util.*;

public final class FileUtils {


    public static OutputStream openFileForWriting(String path) throws IOException {
        return new FileOutputStream(path);
    }

    public static InputStream openFileForReading(String path) throws FileNotFoundException {
        return new FileInputStream(path);
    }
}
