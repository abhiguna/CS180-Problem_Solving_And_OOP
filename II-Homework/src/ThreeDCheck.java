public class ThreeDCheck {
    public static void main(String[] args) throws UnexpectedSideLengthException {
        Pyramid p = new Pyramid(10,10);
        Sphere s = new Sphere(10, 10);
        Cube c = new Cube(10);
        System.out.println(p.toString());
        System.out.println(s.toString());
        System.out.println(c.toString());
    }
}
