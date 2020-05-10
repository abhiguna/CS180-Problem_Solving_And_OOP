public class BetterWheel {
    private double radius;
    public BetterWheel(double radius) {
        this.radius = radius;
    }
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }

    //Accessors - accesses the values of the fields
    public double getRadius() {
        return radius;
    }

    //Mutators -- changes the value of the fields
    public void setRadius(double r) {
        if (r>0 && r<=1000)
            radius=r;
    }
}
