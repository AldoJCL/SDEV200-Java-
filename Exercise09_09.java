public class Exercise09_09 {
    public static void main(String[] args) {
        // Create the three polygons required by the assignment
        RegularPolygon polygon1 = new RegularPolygon();
        RegularPolygon polygon2 = new RegularPolygon(6, 4);
        RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

        // Display perimeter and area for the default polygon
        System.out.println("Polygon 1");
        System.out.println("Perimeter: " + polygon1.getPerimeter());
        System.out.println("Area: " + polygon1.getArea());

        System.out.println();

        // Display perimeter and area for the polygon with 6 sides
        System.out.println("Polygon 2");
        System.out.println("Perimeter: " + polygon2.getPerimeter());
        System.out.println("Area: " + polygon2.getArea());

        System.out.println();

        // Display perimeter and area for the polygon with center coordinates
        System.out.println("Polygon 3");
        System.out.println("Perimeter: " + polygon3.getPerimeter());
        System.out.println("Area: " + polygon3.getArea());
    }
}

class RegularPolygon {
    // Number of sides in the polygon
    private int n = 3;

    // Length of each side
    private double side = 1;

    // Center point of the polygon
    private double x = 0;
    private double y = 0;

    // No-argument constructor uses the default values above
    public RegularPolygon() {
    }

    // Constructor for a polygon centered at (0, 0)
    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
    }

    // Constructor for a polygon with custom sides, side length, and center point
    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    // Getter and setter for number of sides
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    // Getter and setter for side length
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    // Getter and setter for x-coordinate
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    // Getter and setter for y-coordinate
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Perimeter is the number of sides times the side length
    public double getPerimeter() {
        return n * side;
    }

    // Area formula for a regular polygon
    public double getArea() {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }
}