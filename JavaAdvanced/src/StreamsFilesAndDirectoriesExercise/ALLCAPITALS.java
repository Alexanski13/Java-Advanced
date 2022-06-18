package StreamsFilesAndDirectoriesExercise;

import java.io.*;
import java.util.Locale;

public class ALLCAPITALS {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\subze\\IdeaProjects\\JavaAdvanced\\src\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
             PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"))) {

            bufferedReader.lines().forEach(line -> System.out.println(line.toUpperCase(Locale.ROOT)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
