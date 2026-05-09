

import java.util.Scanner;

public class Exercise11_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the triangle sides from the user
        System.out.print("Enter three sides of the triangle: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        // Get the color
        System.out.print("Enter a color: ");
        String color = input.next();

        // Get whether it is filled or not
        System.out.print("Enter true or false for filled: ");
        boolean filled = input.nextBoolean();

        // Make the triangle object with the sides entered
        Triangle triangle = new Triangle(side1, side2, side3);

        // Set the inherited color and filled values
        triangle.setColor(color);
        triangle.setFilled(filled);

        System.out.println();
        System.out.println(triangle.toString());
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled());

        input.close();
    }
}