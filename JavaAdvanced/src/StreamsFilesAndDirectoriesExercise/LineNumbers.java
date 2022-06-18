package StreamsFilesAndDirectoriesExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("src/Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt");
            List<String> lines = Files.readAllLines(path);
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + ". " + lines.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
