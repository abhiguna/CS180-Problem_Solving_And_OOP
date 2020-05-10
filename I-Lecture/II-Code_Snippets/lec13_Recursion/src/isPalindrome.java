public class isPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return true;

        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        if (first != last)
            return false;

        String middle = s.substring(1, s.length() - 1);
        return isPalindrome(middle);
    }
}
