package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        Function<List<Integer>, String> count = list -> "Count = " + list.size();

        String countOutput = count.apply(numbers);

        Function<List<Integer>, Integer> sum = list -> list.stream().mapToInt(e -> e).sum();

        Function<Integer, String> sumFormatter = s -> "Sum = " + s;

        System.out.println(countOutput);

        String sumOutput = sumFormatter.apply(sum.apply(numbers));

        System.out.println(sumOutput);
    }
}
