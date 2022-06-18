package FunctionalProgrammingExercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var people = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            Predicate<String> predicate = getPredicate(tokens);
            switch (command) {
                case "Double":
                    List<String> peopleToAdd = new ArrayList<>();
                    people.stream().filter(predicate).forEach(p -> peopleToAdd.add(p));
                    people.addAll(peopleToAdd);
                    break;
                case "Remove":
                    people.removeIf(predicate);
                    break;
            }
            input = scanner.nextLine();
        }
        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(people);
            String results = String.join(", ", people) + " are going to the party!";
            System.out.println(results);
        }
    }

    public static Predicate<String> getPredicate(String[] commandParts) {
        Predicate<String> predicate = null;
        String filterName = commandParts[1];
        String filterCriteria = commandParts[2];

        switch (filterName) {
            case "StartsWith":
                predicate = name -> name.startsWith(filterCriteria);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(filterCriteria);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(filterCriteria);
                break;
        }
        return predicate;
    }
}
