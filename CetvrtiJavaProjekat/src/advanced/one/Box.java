package advanced.one;
//T - generički odnosno generalni tip podatka
//scope - opseg vidljivosti je blok koda ove klase
// Generički tipovi:
// 1. Unbounded 
// 2. Bounded 
public class Box<T> {

    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
    // generički tip na nivou nestatičke funkcije // U - int new Integer(23)
    public <U extends Number> void inspect(U u){
        System.out.println("T je tipa: " + object.getClass().getName());
        System.out.println("U je tipa: " + u.getClass().getName());
    }
    
    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        System.out.println(box1.toString());
    }
}
