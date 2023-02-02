/**
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
 *
 * Example 1:
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 *
 * Example 2:
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 *
 * Example 3:
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 *
 * Time and Space Complexity
 * TC : O(M) M -> words array length, N -> length of each order. on each word comparison we are not iterating through all the char so, instead we are checking for all the words in the array TC will be O(M)
 * SC : O(1) we are storing fixed size (26) elements in the array, so it's not dependent on the growth of input
 */
public class P_953_Verifying_an_Alien_Dictionary {
    public static void main(String[] args) {
        String[] words = new String[]{"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        boolean res = isAlienSorted(words, order);
        System.out.println(res);
    }

    public static boolean isAlienSorted(String[] words, String order) {
        int[] alienChar = new int[26];
        int N = words.length;

        /**
         * map normal alphabetical order with aliens order
         * Their char index will be stored to our char index
         */
        for (int i = 0; i < order.length(); i++) {
            alienChar[order.charAt(i) - 'a'] = i;
        }

        /**
         * Iterate through each 2 words and compare if they are matching
         */
        for (int i = 1; i < N; i++) {
            if (compare(words[i-1], words[i], alienChar) > 0) {
                return false;
            }
        }
        return true;
    }

    public static int compare(String word1, String word2, int[] alienChar) {
        int compareValue = 0;
        int i = 0, j = 0;

        while (i < word1.length() && j < word2.length() && compareValue == 0) {
            compareValue = alienChar[word1.charAt(i) - 'a'] - alienChar[word2.charAt(j) - 'a'];
            // compare both char value if they are same then difference will be 0. if not it will break the loop and return false;
            i++;
            j++;
        }

        if (compareValue == 0) {
            return word1.length() - word2.length();
        }

        return compareValue;
    }
}
