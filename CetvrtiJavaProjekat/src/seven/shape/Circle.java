package seven.shape;

public class Circle extends Shape {
    
    private double r;
    
    public Circle(int x, int y, String color, String name, double r) {
        super(x, y, color, name);
        this.r = r;
    }

    @Override
    public double calculateArea() {
        double area = r*r*PI;
        return area;
    }
}
