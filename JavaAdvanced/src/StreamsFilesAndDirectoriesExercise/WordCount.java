package StreamsFilesAndDirectoriesExercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new FileReader("src/Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt"));
             Scanner textScanner = new Scanner(new FileReader("src/Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt"));
             PrintWriter printWriter = new PrintWriter("results.txt")) {
            Map<String, Integer> wordCount = new LinkedHashMap<>();
            Arrays.stream(scanner.nextLine().split("\\s+")).forEach(word -> wordCount.put(word, 0));
            while (textScanner.hasNext()) {
                String textInput = textScanner.next();
                if (wordCount.containsKey(textInput)) {
                    int occurrences = wordCount.get(textInput);
                    occurrences++;
                    wordCount.put(textInput, occurrences);
                }
            }
            wordCount.entrySet().forEach(entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
