import java.util.*;
/**
 * Program Name
 *
 * brief description of the program
 *
 * a list of your sources of help (if any)
 *
 * @author Abhishek Gunasekar, CS 180 Black
 * @version 09/24/19
 *
 */
public class Cartesian {
    private double x;
    private double y;

    public Cartesian() {
        x = 0.0;
        y = 0.0;
    }
    public Cartesian(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistance(Cartesian cartesian) {
        double x1 = this.x;
        double x2 = cartesian.x;
        double y1 = this.y;
        double y2 = cartesian.y;
        return (Math.sqrt((Math.pow((x1 - x2), 2.0)) + (Math.pow((y2 - y1), 2.0))));
    }

    public Polar toPolar() {
        double r = Math.sqrt(Math.pow((this.x), 2.0) + Math.pow((this.y), 2.0));
        double theta = Math.atan2(this.y, this.x);
        Polar newPol = new Polar(r, theta);
        return newPol;
    }

    public String toString() {
        String xStr = String.format("%.6f", x);
        String yStr = String.format("%.6f", y);
        return "(" + xStr + ", " + yStr + ")";
    }
}
