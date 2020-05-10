public class Collatz {
    int count(int n) {
        int c = 1;
        while (n > 1) {
            c++;
            if (n % 2 == 0)
                n /= 2;
            else
                n = 3 * n + 1;
        }
        return c;
    }
    public static void main(String[] args) {
        Collatz c = new Collatz();
        System.out.println(c.count(22));
        System.out.println(c.count(1));
        System.out.println(c.count(1000));
    }
}