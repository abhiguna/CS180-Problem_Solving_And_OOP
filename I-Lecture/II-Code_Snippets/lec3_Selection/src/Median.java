import java.util.*;

public class Median {
    double median(double x, double y, double z) {
        if (x <= y && y <= z || z <= y && y <= x)
            return y;
        else if (y <= x && x <= z || z <= x && x <= y)
            return x;
        else if (x <= z && z <= y || y <= z && z <= x)
            return z;
        else
            return 0;
    }
}
