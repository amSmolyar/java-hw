package javaBasics.GenericSeveralParam;

public class Box<K, T> {
    private K key;
    private T obj;

    public Box(K key, T obj) {
        this.key = key;
        this.obj = obj;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public K getKey() {
        return this.key;
    }

    public T getObj() {
        return this.obj;
    }

    @Override
    public String toString() {
        return ("Box{key = " + key +
                "; keyType = " + key.getClass().getName() +
                "; obj = " + obj +
                "; objType = " + obj.getClass().getName() + "}");
    }
}


