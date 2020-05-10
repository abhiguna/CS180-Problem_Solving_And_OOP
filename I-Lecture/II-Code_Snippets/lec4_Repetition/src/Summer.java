import java.util.*;

public class Summer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number;  // number that is input
        int sum = 0; // sum of values
        int c = 0; // how many values read

        while (in.hasNextInt()) {
            number = in.nextInt();
            c = c + 1;
            sum = sum + number;
        }

        System.out.printf("sum of %d values is %d\n", c, sum);
    }
}
