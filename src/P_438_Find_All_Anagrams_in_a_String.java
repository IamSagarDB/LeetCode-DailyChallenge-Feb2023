import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * <p>
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * Example 2:
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 * <p>
 * Time and Space Complexity
 * TC : O(26 * S) -> O(S)  S: length of the string , 26 * S -> on each iteration of S we are checking if 2 array of size 26 are equal
 * SC : O(26) -> O(1)
 */

public class P_438_Find_All_Anagrams_in_a_String {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = findAnagrams(s, p);
        for (int n : res){
            System.out.print(n + " ");
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        int[] sHash = new int[26];
        int[] pHash = new int[26];
        int sLen = s.length();
        int pLen = p.length();

        if (pLen > sLen) return res;

        int left = 0, right = 0;

        // Sliding window
        while (right < pLen) {
            char sChar = s.charAt(right);
            char pChar = p.charAt(right);
            sHash[sChar - 'a'] += 1;
            pHash[pChar - 'a'] += 1;

            right++;
        }

        if (Arrays.equals(sHash, pHash)) {
            res.add(left);
        }

        while (right < sLen) { // S iteration
            char lChar = s.charAt(left);
            char rChar = s.charAt(right);

            sHash[lChar - 'a'] -= 1;
            sHash[rChar - 'a'] += 1;

            right++;
            left++;

            // O(S * 26)
            if (Arrays.equals(sHash, pHash)) { // checking array of length 26 if both are equal
                res.add(left);
            }
        }
        return res;
    }
}
