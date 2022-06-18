package SetsAndMapsAdvancedLab;

import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<String> licensePlates = new LinkedHashSet<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split(", ");

            String plate = tokens[1];

            switch (tokens[0]) {
                case "IN":
                    licensePlates.add(plate);
                    break;
                case "OUT":
                    licensePlates.remove(plate);
                    break;
            }
            input = scanner.nextLine();
        }
        if (licensePlates.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), licensePlates));
        }
    }
}
