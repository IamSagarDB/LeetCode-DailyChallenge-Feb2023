import java.util.Arrays;

/**
 * 567. Permutation in String
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * Example 1:
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 * Constraints:
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 *
 * Time and Space Complexity
 * TC : O(N)
 * SC : O(26) -> O(1)
 */
public class P_567_Permutation_in_String {
    public static void main(String[] args) {
        /**
         * Need to check if S1 string is part of S2 string as anagram (if 2 string are reorder and equal then its anagram)
         */
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean res = checkInclusion(s1, s2);
        System.out.println(res);
    }

    public static boolean checkInclusion(String s1, String s2) {
        int s1L = s1.length();
        int s2L = s2.length();
        if (s1L > s2L) return false; // s2 len should be greater than s1

        int[] s1Hash = new int[26];
        int[] s2Hash = new int[26];

        // pre-process the sliding window for length s1L
        int left = 0, right = 0;
        while (right < s1L) {
            char s1C = s1.charAt(right);
            char s2C = s2.charAt(right);
            s1Hash[s1C - 'a'] += 1;
            s2Hash[s2C - 'a'] += 1;
            right++;
        }

        // check if 2 array are equal then return true
        if (Arrays.equals(s1Hash, s2Hash)) {
            return true;
        }

        /**
         * move the window and add and remove char, check if both array are equal.
         * If arrays are equal at any point then return true.
         */
        while (right < s2L) {
            char leftChar = s2.charAt(left);
            char rightChar = s2.charAt(right);

            s2Hash[leftChar - 'a'] -= 1;
            s2Hash[rightChar - 'a'] += 1;

            if (Arrays.equals(s1Hash, s2Hash)) {
                return true;
            }

            left++;
            right++;
        }

        return false;
    }
}
