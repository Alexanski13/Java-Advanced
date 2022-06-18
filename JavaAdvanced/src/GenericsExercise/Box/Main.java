package GenericsExercise.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Double> box = new Box<>();

        while (n-- > 0) {
            Double element = Double.valueOf(scanner.nextLine());
            box.add(element);
        }

//        String[] indices = scanner.nextLine().split("\\s+");
//        int firstIndex = Integer.parseInt(indices[0]);
//        int secondIndex = Integer.parseInt(indices[1]);
//        box.swap(firstIndex, secondIndex);

        String elementToCompare = scanner.nextLine();

        System.out.println(box.countGreaterItems(Double.valueOf(elementToCompare)));

    }
}
