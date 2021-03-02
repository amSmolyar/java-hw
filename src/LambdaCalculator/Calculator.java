package LambdaCalculator;

import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> supplier = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> sub = (x, y) -> x - y;
    BinaryOperator<Integer> mult = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> {
        try {
            if (y == 0)
                throw new ArithmeticException("Деление на ноль");
            return (x / y);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    };

    UnaryOperator<Integer> pow = (x) -> x * x;
    UnaryOperator<Integer> abs = (x) -> (x > 0) ? x : (x * (-1));

    Predicate<Integer> isPositive = (x) -> x > 0;

    Consumer<Integer> print = System.out::println;

    public Calculator() {
    }
}
