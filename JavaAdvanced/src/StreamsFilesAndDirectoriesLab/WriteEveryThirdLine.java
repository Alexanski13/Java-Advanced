package StreamsFilesAndDirectoriesLab;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\subze\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesLab\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("every-third-line-out.txt"));

        String line = bufferedReader.readLine();

        int counter = 0;

        while (line != null) {
            counter++;

            if (counter % 3 == 0) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            line = bufferedReader.readLine();

        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
