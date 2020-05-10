public class BinaryConverter {
    String convertToBinary(int n) {
        String result = "";

        //handle special cases...
        if (n < 0) {
            return null; //failure
        }
        if (n == 0) {
            return "";
        }

        //loop while n > 0, accumulating a but and dividing by 2...
        while (n > 0) {
            if (n % 2 == 0) {
                result = "0" + result;
            }
            else {
                result = "1" + result;
            }
            n = n / 2;
        }
        return result;
    }
}
