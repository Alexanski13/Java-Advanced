package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\subze\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesLab\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\subze\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesLab\\output.txt");

            int read = inputStream.read();

            while (read != -1) {
                if (read != ',' && read != '.' && read != '!' && read != '?') {
                    outputStream.write(read);
                }

                read = inputStream.read();
            }

        } catch (IOException ignored) {
        }
    }
}
