package Module2.Exercise13_09;

public abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    // no-arg constructor
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    // constructor with color and filled
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    // returns color
    public String getColor() {
        return color;
    }

    // sets color
    public void setColor(String color) {
        this.color = color;
    }

    // returns true if filled
    public boolean isFilled() {
        return filled;
    }

    // sets filled
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // returns date created
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    // returns string information
    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
            " and filled: " + filled;
    }

    // abstract area method
    public abstract double getArea();

    // abstract perimeter method
    public abstract double getPerimeter();
}