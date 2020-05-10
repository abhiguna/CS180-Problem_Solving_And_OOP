/**
 * The {@code ColorEngine} class is what defines the Color fixer algorithm. It will read the broken file in,
 * collapse the array twice, via the {@code collapseArrayList} method, and the {@code analyzeColors} method.
 *
 * @author Abhishek Gunasekar agunase
 * @version 10-12-2019 1.0
 */
public class Pyramid implements ThreeDimensionalShape {
    private String name;
    private double length;
    private double height;

    public Pyramid(double length, double height) throws UnexpectedSideLengthException {
        if (length < 0.0 || height < 0.0) {
            throw new UnexpectedSideLengthException();
        } else {
            this.length = length;
            this.height = height;
        }
        this.name = "Pyramid";
    }

    public double getSideLength() {
        return this.length;
    }

    public double getHeight() {
        return this.height;
    }

    public double calculateVolume() {
        return (length * length * height) / 3;
    }

    public double calculateSurfaceArea() {
        return this.getSideLength() * (this.getSideLength() + Math.sqrt((Math.pow(length, 2)) +
                (4 * Math.pow(height, 2))));
    }

    public String getName() {
        return name;
    }

    public int getNumSides() {
        return 4;
    }

    public double calculatePerimeter() {
        return (4 * (Math.pow(height, 2) + (Math.pow(length, 2) / 4.0))) + (4 * length);
    }

    public boolean equals(Object o) {
        return (this.name.equals(((Pyramid) o).getName())) && (this.length == (((Pyramid) o).getSideLength())) &&
                (this.height == (((Pyramid) o).getHeight()));
    }

    public String toString() {
        return "Pyramid[" + String.format("%.2f", this.getSideLength()) + ", " + String.format("%.2f", this.getHeight())
                + ", " + String.format("%.2f", this.calculatePerimeter()) + ", " +
                String.format("%.2f", this.calculateVolume()) + ", " +
                String.format("%.2f", this.calculateSurfaceArea()) + "]";
    }
}
