import java.util.*;

public class AbsValue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = 0;
        x = in.nextInt();
        System.out.printf("BEFORE: x = %d\n", x);
        if (x < 0) {
            x = -x;
        }
        System.out.printf("AFTER: x = %d\n", x);
    }
}
