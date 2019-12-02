package eight.interfaces;

public class Box<T> {

    //String, Person, Double, int
    private T properties;

    public Box(T properties) {
        this.properties = properties;
    }

    public T getProperties() {
        return properties;
    }

}
