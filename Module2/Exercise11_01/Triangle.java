package Module2;

public class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    // No-arg constructor for the default triangle
    public Triangle() {
    }

    // Constructor that lets the user set the three sides
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Getters for the sides
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    // Uses Heron's formula to find the area
    public double getArea() {
        double s = getPerimeter() / 2;

        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // Adds all the sides together
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // Returns the triangle description required by the assignment
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 +
                " side3 = " + side3;
    }
}