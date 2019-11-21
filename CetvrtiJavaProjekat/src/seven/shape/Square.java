package seven.shape;

public class Square extends Shape {

    private double a;

    public Square(int x, int y, String color, String name, double a) {
        super(x, y, color, name);
        this.a = a;
    }

    @Override
    public double calculateArea() {
        return a*a;
    }

}
