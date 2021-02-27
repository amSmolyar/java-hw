package GenericFirst;

public class GenericFirst {
    public static void main(String[] args) {
        Box<String> boxString = new Box<>("Коробулька");
        Box<Integer> boxInteger = new Box<>(9);
        Box<Boolean> boxBoolean = new Box<>(true);

        //объявление с ошибкой:
        //Box<String> boxString2 = new Box<>(27);

        System.out.println(boxString.toString());
        System.out.println(boxInteger.toString());
        System.out.println(boxBoolean.toString());
    }
}
