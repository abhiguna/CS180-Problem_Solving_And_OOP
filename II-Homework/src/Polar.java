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
public class Polar {
    private double r;
    private double theta;

    public Polar() {
        this.r = 0.0;
        this.theta = 0.0;
    }

    public Polar(double r, double theta) {
        this.r = r;
        this.theta = theta;
    }

    public double getR() {
        return r;
    }

    public double getTheta() {
        return theta;
    }

    public double getDistance(Polar polar) {
        double x1 = r * Math.cos(theta);
        double y1 = r * Math.sin(theta);
        double x2 = polar.r * Math.cos(polar.theta);
        double y2 = polar.r * Math.sin(polar.theta);
        return (Math.sqrt((Math.pow((x1 - x2), 2.0)) + (Math.pow((y2 - y1), 2.0))));
    }

    public Cartesian toCartesian() {
        Cartesian newCart = new Cartesian(r * Math.cos(theta), r * Math.sin(theta));
        return newCart;
    }

    public String toString() {
        String rStr = String.format("%.6f", r);
        String thetaStr = String.format("%.6f", theta);
        return "(" + rStr + ", " + thetaStr + ")";
    }

}
