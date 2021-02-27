package GenericSeveralParam;

public class GenericSeveralParam {
    public static void main(String[] args) {
        Box<String, String> box1 = new Box<>("золотой ключик", "вкусняшки");
        Box<String, Integer> box2 = new Box<>("пончик", 73);
        Box<Integer, Boolean> box3 = new Box<>(123, true);

        System.out.println(box1.toString());
        System.out.println(box2.toString());
        System.out.println(box3.toString());
    }
}
