import java.util.HashMap;
import java.util.Map;

/**
 * 6. Zigzag Conversion
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * <p>
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * Example 3:
 * Input: s = "A", numRows = 1
 * Output: "A"
 * <p>
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 * <p>
 * Time and Space Complexity
 * TC : O(N) N -> length of the string
 * SC : O(M) M -> number of row
 */

public class P_6_Zigzag_Conversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String res = convert(s, numRows);
        System.out.println(res);  //PAHNAPLSIIGYIR
    }

    /**
     * travers the string and add that each character into Map of length numRows from (top to bottom) and (bottom to top)
     * after adding concatenate all the string from Map from 0 -> numRows
     */
    public static String convert(String s, int numRows) {
        Map<Integer, StringBuilder> map = new HashMap<Integer, StringBuilder>();
        int pointer = 0;
        int index = 0;
        boolean rev = false;

        if (numRows == 1) return s;
        while (pointer < s.length()) {
            char c = s.charAt(pointer);
            if (map.containsKey(index)) {
                map.put(index, map.get(index).append(c));
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                map.put(index, stringBuilder.append(c));
            }

            if (index == 0 || (index < numRows - 1 && !rev)) {
                index++;
                rev = false;
            } else {
                index--;
                rev = true;
            }

            pointer++;
        }

        //System.out.println(map.entrySet());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.entrySet().size(); i++) {
            sb.append(map.get(i));
        }
        return sb.toString();
    }
}
