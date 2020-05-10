public class PhysicalTrees {
    double circumference;
    static int numberOfTrees = 0;

    PhysicalTrees(double circumference) {
        this.circumference = circumference;
        numberOfTrees = numberOfTrees + 1;
    }

    // Non-Static Method
    double getRadius() {
        return circumference / (2 * Math.PI);
    }

    //Static-Method
    static int getNumberOfTrees() {
        return numberOfTrees;
    }
}
