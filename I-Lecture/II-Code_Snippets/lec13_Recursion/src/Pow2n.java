public class Pow2n {
    public static long pow2n(long n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return 2;
        else {
            long t = pow2n(n / 2);
            if (n % 2 == 0)
                return t * t;
            else
                return 2 * t * t;
        }
    }
}
