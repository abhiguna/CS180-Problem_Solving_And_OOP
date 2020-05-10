import java.util.Scanner;
import java.util.NoSuchElementException;

public class EOF {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            try {
                String word = s.next();
                System.out.println(word);
            } catch (NoSuchElementException e) {
                System.out.printf("NoSuchElementException:%s\n",e.getMessage());
                break;
            }
        }
    }
}