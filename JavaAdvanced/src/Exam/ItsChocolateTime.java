package Exam;

import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> powderStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(powderStack::push);

        Map<String, Integer> chocolatesMade = new TreeMap<>();

        chocolatesMade.put("Milk Chocolate", 0);
        chocolatesMade.put("Dark Chocolate", 0);
        chocolatesMade.put("Baking Chocolate", 0);

        while (!milkQueue.isEmpty() && !powderStack.isEmpty()) {
            double milk = milkQueue.poll();
            double powder = powderStack.pop();

            double percentage = powder / (milk + powder);

            if (percentage < 0.3) {
                milk += 10;
                milkQueue.offer(milk);
            }


            String chocolatePrepared;
            if (percentage == 0.3) {
                chocolatePrepared = "Milk Chocolate";
            } else if (percentage == 0.5) {
                chocolatePrepared = "Dark Chocolate";
            } else if (percentage == 1) {
                chocolatePrepared = "Baking Chocolate";
            } else {
                chocolatePrepared = null;
            }

            if (chocolatePrepared != null) {
                if (chocolatesMade.containsKey(chocolatePrepared)) {
                    int newVal = chocolatesMade.get(chocolatePrepared) + 1;
                    chocolatesMade.put(chocolatePrepared, newVal);
                } else {
                    chocolatesMade.putIfAbsent(chocolatePrepared, 1);
                }
            }

        }

        boolean allChocolatesMade = chocolatesMade.entrySet().stream().allMatch(e -> e.getValue() > 0);

        if (allChocolatesMade) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolatesMade.entrySet().forEach(s -> {
            if (s.getValue() > 0) {
                System.out.printf("# %s --> %d%n", s.getKey(), s.getValue());
            }
        });
    }
}
