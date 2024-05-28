package task3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java task3.Main <directory>");
            System.exit(1);
        }

        String directoryPath = args[0];

        try {
            GitInit.initializeRepository(directoryPath);
        } catch (IOException e) {
            System.err.println("Error initializing Git repository: " + e.getMessage());
            System.exit(1);
        }
    }
}
