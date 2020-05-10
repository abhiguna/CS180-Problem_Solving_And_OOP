import java.util.*;

public class OddOrEven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int readInteger = 0;
        while (in.hasNextInt()) {
            readInteger = in.nextInt();
            if (readInteger % 2 == 0) {
                System.out.printf("%d is even\n", readInteger);
            }
            else {
                System.out.printf("%d is odd\n", readInteger);
            }
        }
    }
}
