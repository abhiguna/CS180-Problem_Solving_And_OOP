public class Sum2d {
    int computeSum(int[][] Arr2d) {
        int sum = 0;
        for (int i = 0; i < Arr2d.length; i++) {
            for (int j = 0; j < Arr2d[i].length; j++) {
                sum += Arr2d[i][j];
            }
        }
        return sum;
    }
}
