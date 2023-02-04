import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean res = checkInclusion(s1, s2);
        System.out.println(res);
    }

    public static boolean checkInclusion(String s1, String s2) {
        int s1L = s1.length();
        int s2L = s2.length();
        if (s1L > s2L) return false;

        int[] s1Hash = new int[26];
        int[] s2Hash = new int[26];

        // pre prodcess the sliding windown for length s1L
        int left = 0, right = 0;
        while (right < s1L) {
            char s1C = s1.charAt(right);
            char s2C = s2.charAt(right);
            s1Hash[s1C - 'a'] += 1;
            s2Hash[s2C - 'a'] += 1;
            right++;
        }

        if (Arrays.equals(s1Hash, s2Hash)) {
            return true;
        }

//        System.out.println("S1: "+Arrays.toString(s1Hash));
//        System.out.println("S2: "+Arrays.toString(s2Hash));
//        System.out.println();


        while (right < s2L) {
            char leftChar = s2.charAt(left);
            char rightChar = s2.charAt(right);

//            System.out.println("S2 pre: " +" "+ leftChar +" "+rightChar + " " +Arrays.toString(s2Hash));
            s2Hash[leftChar - 'a'] -= 1;
            s2Hash[rightChar - 'a'] += 1;

            if (Arrays.equals(s1Hash, s2Hash)) {
                return true;
            }

//            System.out.println("S2 post: "+Arrays.toString(s2Hash));
//            System.out.println();

            left++;
            right++;
        }

        return false;

    }
}