/**
 * The {@code ColorEngine} class is what defines the Color fixer algorithm. It will read the broken file in,
 * collapse the array twice, via the {@code collapseArrayList} method, and the {@code analyzeColors} method.
 *
 * @author Abhishek Gunasekar agunase
 * @version 10-12-2019 1.0
 */
public class Sphere implements ThreeDimensionalShape {
    private String name;
    private double radius;
    private double thickness;

    public Sphere(double radius, double thickness) throws UnexpectedSideLengthException {
        if ((radius < 0.0) || (thickness < 0.0)) {
            throw new UnexpectedSideLengthException();
        }
        this.radius = radius;
        this.thickness = thickness;
        if (thickness == 0.0) {
            this.name = "Sphere";
        } else if (thickness > 0.0) {
            this.name = "Ball";
        }
    }

    public double getSideLength() {
        return 0.0;
    }

    public double calculateVolume() {
        return (((4.0 / 3.0) * Math.PI) * Math.pow(radius, 3));
    }

    public double calculateSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public String getName() {
        return name;
    }

    public int getNumSides() {
        return 0;
    }

    public double calculatePerimeter() {
        return 0;
    }

    public double getRadius() {
        return radius;
    }

    public double getThickness() {
        return thickness;
    }

    public boolean equals(Object o) {
        return (this.name.equals(((Sphere) o).getName())) && (this.radius == (((Sphere) o).getRadius()) &&
                (this.thickness == (((Sphere) o).getThickness())));
    }

    public String toString() {
        return "Sphere[" + String.format("%.2f", this.getRadius()) + ", " + String.format("%.2f", this.getThickness())
                + ", " + this.getName() + ", " + String.format("%.2f", this.calculateVolume()) + "]";

    }
}
