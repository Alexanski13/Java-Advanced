package StreamsFilesAndDirectoriesLab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\subze\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesLab\\input.txt";

        var sortedLines = Files.readAllLines(Paths.get(path))
                .stream()
                .sorted()
                .collect(Collectors.toList());

        var outputPath = Path.of("sorted-lines-out.txt");

        Files.write(outputPath, sortedLines, StandardOpenOption.WRITE);
    }
}
