public class Fibonacci {
    static int[] fibonacci(int n) {
        int[] fibNumbers = new int[n];
        fibNumbers[0] = 0;
        if (n > 1) {
            fibNumbers[1] = 1;
            if (n > 2) {
                for (int i = 2; i < n; i++) {
                    fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2];
                }
            }
        }
        return fibNumbers;
    }

    public static void main(String[] args) {
        int[] newFib = new int[3];
        newFib = fibonacci(4);
        for (int i = 0; i < newFib.length; i++) {
            System.out.println(newFib[i]);
        }
    }
}
