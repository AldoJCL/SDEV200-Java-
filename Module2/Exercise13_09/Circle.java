package Module2.Exercise13_09;

public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    // no-arg constructor
    public Circle() {
    }

    // constructor with radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // constructor with radius, color, and filled
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    // returns radius
    public double getRadius() {
        return radius;
    }

    // sets radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // returns area
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    // returns diameter
    public double getDiameter() {
        return 2 * radius;
    }

    // returns perimeter
    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    // compares two Circle objects by radius
    @Override
    public int compareTo(Circle otherCircle) {
        if (radius > otherCircle.radius) {
            return 1;
        }
        else if (radius < otherCircle.radius) {
            return -1;
        }
        else {
            return 0;
        }
    }

    // two Circle objects are equal if their radii are the same
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            return radius == ((Circle)obj).radius;
        }

        return false;
    }

    // prints circle info
    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated()
            + " and the radius is " + radius);
    }
}