package IteratorsAndComparatorsExercice.ListryIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        ListyIterator listyIterator = null;
        while (!line.equals("END")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Create":
//                    String[] elements = new String[tokens.length - 1];
//                    for (int i = 1; i < tokens.length; i++) {
//                        elements[i - 1] = tokens[i];
//                    }
                    if (tokens.length > 1) {
                        listyIterator = new ListyIterator(Arrays.copyOfRange(tokens, 1, tokens.length));
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    for (String element : listyIterator) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                    break;
            }

            line = scanner.nextLine();
        }
    }
}
