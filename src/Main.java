import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = findAnagrams(s, p);
        for (Integer n : res){
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

        for (int x : pHash){
            System.out.print(x + " ");
        }
        System.out.println();

        for (int x : sHash){
            System.out.print(x + " ");
        }
        System.out.println();

        while (right < sLen) {
            char lChar = s.charAt(left);
            char rChar = s.charAt(right);

            sHash[lChar - 'a'] -= 1;
            sHash[rChar - 'a'] += 1;

            for (int x : sHash){
                System.out.print(x + " ");
            }
            System.out.println();

            right++;
            left++;

            if (Arrays.equals(sHash, pHash)){
                res.add(left);
            }
        }


        return res;
    }
}