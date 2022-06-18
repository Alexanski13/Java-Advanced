package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emailRegister = new LinkedHashMap<>();

        String name = scanner.nextLine();

        while (!name.equals("stop")) {
            String emails = scanner.nextLine();
            if (!emails.contains(".us") && !emails.contains(".uk") && !emails.contains(".com")) {
                emailRegister.put(name, emails);
            }
            name = scanner.nextLine();
        }
        for (Map.Entry<String, String> pair : emailRegister.entrySet()) {
            System.out.printf("%s -> %s%n", pair.getKey(), pair.getValue());
        }
    }
}
