package stream.workWithNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        System.out.println("Исходный массив чисел:");
        intList.stream()
            .forEach(x -> System.out.printf("%d ", x));

        System.out.println("\nОтфильтрованные числа в порядке возрастания:");
        intList.stream()
                .filter(x -> (x > 0))
                .filter(x -> (x % 2 == 0))
                .sorted()
                .forEach(x -> System.out.printf("%d ", x));
    }
}
