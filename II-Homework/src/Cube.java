/**
 * The {@code ColorEngine} class is what defines the Color fixer algorithm. It will read the broken file in,
 * collapse the array twice, via the {@code collapseArrayList} method, and the {@code analyzeColors} method.
 *
 * @author Abhishek Gunasekar agunase
 * @version 10-12-2019 1.0
 */
public class Cube implements ThreeDimensionalShape {
    private String name;
    private double sideLength;

    public Cube(double sideLength) throws UnexpectedSideLengthException {
        if (sideLength < 0.0) {
            throw new UnexpectedSideLengthException();
        } else {
            this.sideLength = sideLength;
        }
        this.name = "Cube";
    }

    public double getSideLength() {
        return sideLength;
    }

    public double calculateVolume() {
        return sideLength * sideLength * sideLength;
    }

    public double calculateSurfaceArea() {
        return 6 * Math.pow(sideLength, 2);
    }

    public String getName() {
        return name;
    }

    public int getNumSides() {
        return 6;
    }

    public double calculatePerimeter() {
        return 12 * sideLength;
    }

    public boolean equals(Object o) {
        return (this.name.equals(((Cube) o).getName())) && (this.sideLength == (((Cube) o).getSideLength()));
    }

    public String toString() {
        return "Cube[" + String.format("%.2f", this.getSideLength()) + ", " +
                String.format("%.2f", this.calculatePerimeter()) + ", " + String.format("%.2f", this.calculateVolume())
                + ", " + String.format("%.2f", this.calculateSurfaceArea()) + "]";
    }
}
