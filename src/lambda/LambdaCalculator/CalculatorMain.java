package lambda.LambdaCalculator;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator calc = Calculator.supplier.get();

        int a1 = calc.plus.apply(2,8);
        calc.print.accept(a1);   //10

        int b1 = calc.mult.apply(a1,10);
        calc.print.accept(b1);   //100

        int a2 = calc.abs.apply(-10);
        calc.print.accept(a2);   //10

        int b2 = calc.pow.apply(a2);
        calc.print.accept(b2);   //100

        int c = calc.sub.apply(b1,b2);
        calc.print.accept(c);    //0

        int d = calc.devide.apply(b1,c);
        calc.print.accept(d);

    }
}
