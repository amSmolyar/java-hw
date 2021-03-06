package stream.workWithNumbers;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList(Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4));

        System.out.println("Исходный массив чисел:");
        writeList((x) -> System.out.printf("%d ", x), intList);

        // оставляем только четные положительные числа:
        Iterator<Integer> intListIterator = intList.iterator();
        while (intListIterator.hasNext()) {
            int member = intListIterator.next();
            if ((member <= 0) || (member % 2 != 0))
                intListIterator.remove();
        }

        // сортировка
        intList.sort((a,b) -> (a - b));

        System.out.println("\nОтфильтрованные числа в порядке возрастания:");
        writeList((x) -> System.out.printf("%d ", x), intList);

    }

    public static void writeList(Consumer<Integer> consumer, List<Integer> list) {
        for (int member : list) {
            consumer.accept(member);
        }
    }
}
