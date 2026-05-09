package Module2.Exercise13_09;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(5);
        Circle circle3 = new Circle(10);

        // print basic circle information
        System.out.println("Circle 1 radius: " + circle1.getRadius());
        System.out.println("Circle 2 radius: " + circle2.getRadius());
        System.out.println("Circle 3 radius: " + circle3.getRadius());

        System.out.println();

        // test equals method
        System.out.println("circle1 equals circle2: " + circle1.equals(circle2));
        System.out.println("circle1 equals circle3: " + circle1.equals(circle3));

        System.out.println();

        // test compareTo method
        System.out.println("circle1 compareTo circle2: " + circle1.compareTo(circle2));
        System.out.println("circle1 compareTo circle3: " + circle1.compareTo(circle3));
        System.out.println("circle3 compareTo circle1: " + circle3.compareTo(circle1));

        System.out.println();

        // test inherited GeometricObject methods
        Circle circle4 = new Circle(7, "blue", true);
        System.out.println("Circle 4 radius: " + circle4.getRadius());
        System.out.println("Circle 4 color: " + circle4.getColor());
        System.out.println("Circle 4 filled: " + circle4.isFilled());
        System.out.println("Circle 4 area: " + circle4.getArea());
        System.out.println("Circle 4 perimeter: " + circle4.getPerimeter());
    }
}