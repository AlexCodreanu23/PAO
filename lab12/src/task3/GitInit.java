package task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GitInit {

    public static void initializeRepository(String path) throws IOException {
        File gitDir = new File(path, ".git");

        if (!gitDir.exists()) {
            boolean created = gitDir.mkdirs();
            if (!created) {
                throw new IOException("Failed to create .git directory");
            }
        } else {
            throw new IOException(".git directory already exists");
        }

        File objectsDir = new File(gitDir, "objects");
        File refsDir = new File(gitDir, "refs");

        if (!objectsDir.mkdirs()) {
            throw new IOException("Failed to create objects directory");
        }

        if (!refsDir.mkdirs()) {
            throw new IOException("Failed to create refs directory");
        }

        File headFile = new File(gitDir, "HEAD");
        try (FileWriter writer = new FileWriter(headFile)) {
            writer.write("ref: refs/heads/main\n");
        } catch (IOException e) {
            throw new IOException("Failed to create HEAD file", e);
        }

        System.out.println("Initialized empty Git repository in " + gitDir.getAbsolutePath());
    }
}
