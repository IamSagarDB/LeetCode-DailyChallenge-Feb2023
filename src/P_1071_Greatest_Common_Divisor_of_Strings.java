/**
 * P 1071. Greatest Common Divisor of Strings
 * <p>
 * Question:
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 * <p>
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * <p>
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * <p>
 * Example 2:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * <p>
 * Example 3:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * <p>
 * Constraints:
 * <p>
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 */
public class P_1071_Greatest_Common_Divisor_of_Strings {
    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));
    }

    /***
     * INTUTION and APPROACH:
     *  find the GCD of the string.
     *  check if high length string starts with lower length string .
     *  if yes then keep repeating till both string are equal
     *
     *  if equal then return it. else return empty string
     *
     *  TC and SC
     *  TC : O(N)
     *  SC : O(N)
     *
     */

    public static String gcdOfStrings(String str1, String str2) {
        return isCheck(str1, str2);
    }
    private static String isCheck(String a, String b) {
        if (a.length() == b.length()) {
            if (a.equals(b)) {
                return a;
            } else {
                return "";
            }
        }

        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        if (!a.startsWith(b)) return "";

        return isCheck(a.substring(b.length()), b);
    }
}