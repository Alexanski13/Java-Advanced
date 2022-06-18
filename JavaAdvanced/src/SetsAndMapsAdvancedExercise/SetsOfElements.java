package SetsAndMapsAdvancedExercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] setSizes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int first = setSizes[0];
        Set<String> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < first; i++) {
            firstSet.add(scanner.nextLine());
        }

        int second = setSizes[1];
        Set<String> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < first; i++) {
            secondSet.add(scanner.nextLine());
        }

        for (String element : firstSet) {
            if (secondSet.contains(element)) {
                System.out.print(element + " ");
            }
        }
    }
}
