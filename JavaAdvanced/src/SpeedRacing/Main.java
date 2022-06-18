package SpeedRacing;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> carMap = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double consumption = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, consumption);
            carMap.put(model, car);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commandParts = input.split("\\s+");

            String model = commandParts[1];
            int kilometers = Integer.parseInt(commandParts[2]);

            Car currentCar = carMap.get(model);
            if (!currentCar.hasEnoughFuel(kilometers)) {
                System.out.println("Insufficient fuel for the drive");
            } else {
                currentCar.drive(kilometers);
            }
            input = scanner.nextLine();
        }

        carMap.values().stream().forEach(System.out::println);
    }
}
