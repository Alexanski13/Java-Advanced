package StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;

public class ListFiles {
    public static void main(String[] args) {
        File root = new File("C:\\Users\\subze\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Arrays.stream(root.listFiles())
                .filter(File::isFile)
                .forEach(f -> System.out.println(f.getName() + ": " + "[" + f.length() + "]"));

    }
}
