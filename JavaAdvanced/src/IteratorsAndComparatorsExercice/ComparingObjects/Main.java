package IteratorsAndComparatorsExercice.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> personList = new ArrayList<>();

        while (!input.equals("END")) {
            String[] inputData = input.split("\\s+");
            String name = inputData[0];
            int age = Integer.parseInt(inputData[1]);
            String town = inputData[2];

            Person person = new Person(name, age, town);
            personList.add(person);

            input = scanner.nextLine();
        }

        int comparePersonIndex = Integer.parseInt(scanner.nextLine());
        Person personToCompare = personList.get(comparePersonIndex - 1);

        int totalPeople = personList.size();
        int samePeople = 0;
        int differentPeople = 0;

        for (Person person : personList) {
            if (person.compareTo(personToCompare) == 0) {
                samePeople++;
            } else {
                differentPeople++;
            }
        }

        if (samePeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", samePeople, differentPeople, totalPeople);
        }
    }
}
