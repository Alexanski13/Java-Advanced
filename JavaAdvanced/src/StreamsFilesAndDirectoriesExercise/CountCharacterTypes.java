package StreamsFilesAndDirectoriesExercise;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class CountCharacterTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        try (FileReader fileReader = new FileReader("C:\\Users\\subze\\IdeaProjects\\JavaAdvanced\\src\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt")) {

            int oneSymbol = fileReader.read();
            while (oneSymbol >= 0) {
                char symbolAsChar = (char) oneSymbol;
                if (isVowel(symbolAsChar)) {
                    vowels++;
                } else if (isPunctuation(symbolAsChar)) {
                    punctuation++;
                } else if (!Character.isWhitespace(symbolAsChar)) {
                    consonants++;
                }
                oneSymbol = fileReader.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Punctuation: " + punctuation);
    }

    public static boolean isVowel(char character) {
        return (character == 'a' || character == 'o' || character == 'u' || character == 'e' || character == 'i');
    }

    public static boolean isPunctuation(char character) {
        return (character == '!' || character == '.' || character == ',' || character == '>');
    }
}
