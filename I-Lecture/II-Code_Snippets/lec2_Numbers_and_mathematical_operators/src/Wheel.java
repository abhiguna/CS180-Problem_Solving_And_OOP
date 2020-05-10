import java.util.*;

public class Wheel {
    double radius;

    public Wheel(double radius) {
        this.radius = radius;
    }

    public double getCircumference(){
        return 2 * Math.PI * this.radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
