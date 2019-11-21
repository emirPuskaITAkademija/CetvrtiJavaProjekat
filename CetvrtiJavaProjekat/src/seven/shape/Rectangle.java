package seven.shape;

public class Rectangle extends Shape {

    private double a, b;

    public Rectangle(int x, int y, String color, String name, double a, double b) {
        super(x, y, color, name);
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculateArea() {
        return a*b;
    }
}
