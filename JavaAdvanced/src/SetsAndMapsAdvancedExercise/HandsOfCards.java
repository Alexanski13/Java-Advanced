package SetsAndMapsAdvancedExercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, HashSet<String>> playerCards = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("JOKER")) {
            String[] commandTokens = command.split(": ");
            String name = commandTokens[0];
            String[] cards = commandTokens[1].split(", ");
            if (!playerCards.containsKey(name)) {
                playerCards.put(name, new HashSet<>());
            }
            for (String card : cards) {
                playerCards.get(name).add(card);
            }

            command = scanner.nextLine();
        }
        for (Map.Entry<String, HashSet<String>> player : playerCards.entrySet()) {
            String playerName = player.getKey();
            int points = calculatePoints(player.getValue());
            System.out.printf("%s: %d%n", playerName, points);
        }

    }

    private static int calculatePoints(HashSet<String> cards) {
        int points = 0;
        for (String card : cards) {
            String power = card.substring(0, card.length() - 1);
            char type = card.charAt(card.length() - 1);

            int cardPoints = getPower(power) * getType(type);
            points += cardPoints;
        }
        return points;
    }

    private static int getPower(String power) {
        switch (power) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(power);
        }
    }

    private static int getType(char type) {
        switch (type) {
            case 'S':
                return 4;
            case 'H':
                return 3;
            case 'D':
                return 2;
            case 'C':
                return 1;
            default:
                return 0;
        }
    }
}
