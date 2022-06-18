package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\subze\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesLab\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(inputStream);

        PrintWriter writer = new PrintWriter(new FileOutputStream("integers-out.txt"));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                writer.println(scanner.next());
            } else {
                scanner.next();
            }
        }

        writer.close();
    }
}
