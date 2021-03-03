package javaBasics.GenericExtends;

public class GenericExtends {
    public static void main(String[] args) {
        FruitBox<String, Banana> bananaBox = new FruitBox<>("banana", new Banana());
        bananaBox.getObj().printClass();

        FruitBox<String, Pineapple> appleBox = new FruitBox<>("apple", new Pineapple());
        appleBox.getObj().printClass();

        FruitBox<String, Fruit> fruitBox = new FruitBox<>("fruit", new Fruit());
        fruitBox.getObj().printClass();

        VegetableBox<String, Cabbage> cabbageBox = new VegetableBox<>("cabbage", new Cabbage());
        cabbageBox.getObj().printClass();

        VegetableBox<String, Squash> squashBox = new VegetableBox<>("squash", new Squash());
        squashBox.getObj().printClass();

        VegetableBox<String, Vegetable> vegetableBox = new VegetableBox<>("vegetable", new Vegetable());
        vegetableBox.getObj().printClass();
    }
}
