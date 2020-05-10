import java.util.*;

public class Swapper {
    void Swapper(int x, int y) {
        if (y >= x) {
            int temp = 0;
            temp = x;
            x = y;
            y = temp;
        }
    }
}
