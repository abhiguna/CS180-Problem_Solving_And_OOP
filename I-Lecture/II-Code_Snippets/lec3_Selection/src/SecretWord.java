import java.util.*;

public class SecretWord {
    public static final String SECRET = "TARGET";

    public static void  main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next();

        if (word.equals(SECRET)) {
            System.out.printf("You have said" +
                    " the secret word: '%s'\n", SECRET);
        }
    }
}
