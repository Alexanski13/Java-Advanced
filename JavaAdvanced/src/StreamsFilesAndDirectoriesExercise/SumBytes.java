package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\subze\\IdeaProjects\\JavaAdvanced\\src\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"))) {
            String line = bufferedReader.readLine();

            long sum = 0;
            while (line != null) {
                char[] charsFromLine = line.toCharArray();
                for (char singleChar : charsFromLine) {
                    sum += singleChar;
                }
                line = bufferedReader.readLine();
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
