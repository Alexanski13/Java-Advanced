package SetsAndMapsAdvancedExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> symbolMap = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (!symbolMap.containsKey(current)) {
                symbolMap.put(current, 1);
            } else {
                int currentCount = symbolMap.get(current);
                symbolMap.put(current, ++currentCount);
            }
        }

        for (Map.Entry<Character, Integer> pair : symbolMap.entrySet()) {
            System.out.printf("%s: %d time/s%n", pair.getKey(), pair.getValue());
        }
    }
}
