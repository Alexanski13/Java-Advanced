package SetsAndMapsAdvancedExercise;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> chemicals = new TreeSet<>();

        while (n-- > 0) {
            String[] elements = scanner.nextLine().split("\\s+");
            Collections.addAll(chemicals, elements);

        }

        String result = String.join(" ", chemicals);
        System.out.print(result);
    }
}
