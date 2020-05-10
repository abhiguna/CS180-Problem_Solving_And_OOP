import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
    public static void main(String[] args) {
        var list = new ArrayList<String>();

        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            list.add(s);
        }

        System.out.printf("read %d lines\n", list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s\n", list.get(i));
        }
    }
}