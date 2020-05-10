/**
 * The {@code ColorEngine} class is what defines the Color fixer algorithm. It will read the broken file in,
 * collapse the array twice, via the {@code collapseArrayList} method, and the {@code analyzeColors} method.
 *
 * @author Abhishek Gunasekar agunase
 * @version 10-12-2019 1.0
 */
public interface ThreeDimensionalShape {
    double getSideLength();

    double calculateVolume();

    double calculateSurfaceArea();

    String getName();

    int getNumSides();

    double calculatePerimeter();
}
