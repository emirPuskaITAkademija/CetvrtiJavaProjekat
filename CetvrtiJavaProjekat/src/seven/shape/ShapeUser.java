/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seven.shape;

public class ShapeUser {

    public static void main(String[] args) {
        Circle circle = new Circle(0, 0, "crna", "kruzic", 3);
        Rectangle rectangle = new Rectangle(0, 0, "crvena", "pravougaonik", 2, 3);
        Square square = new Square(0, 0, "zuta", "kvadrat", 3);
        printShapes(circle, rectangle, square);
    }

    //Shape[], circle, rectangle, square
    static void printShapes(Shape... shapes) {
        int i = 0;
        while (i < shapes.length) {
            Shape shape = shapes[i];
            printShape(shape);
            i++;
        }
    }
    // i = 0 -> circle
    // i = 1 -> rectangle
    // i = 2 -> square
    static void printShape(Shape shape) {
        double area = shape.calculateArea();
        System.out.println("Povrsina shape sa nazivom " + shape.getName() + " = " + area);
    }
}
