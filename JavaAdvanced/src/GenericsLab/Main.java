package GenericsLab;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(13, 4, 69, 420);

        System.out.println(ListUtils.getMin(list));
        System.out.println(ListUtils.getMax(list));
    }
}
