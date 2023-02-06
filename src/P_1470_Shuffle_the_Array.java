/**
 * 1470. Shuffle the Array
 * <p>
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 * <p>
 * Example 1:
 * Input: nums = [2,5,1,3,4,7], n = 3
 * Output: [2,3,5,4,1,7]
 * Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 * <p>
 * Example 2:
 * Input: nums = [1,2,3,4,4,3,2,1], n = 4
 * Output: [1,4,2,3,3,2,4,1]
 * <p>
 * Example 3:
 * Input: nums = [1,1,2,2], n = 2
 * Output: [1,2,1,2]
 * <p>
 * Constraints:
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 * <p>
 * Approach 1:
 * Use extra array and store the res value
 * TC : O(N)
 * SC : O(N)
 * <p>
 * Approach 2:
 * User bit manipulation to update existing array
 * Ref : https://www.youtube.com/watch?v=dUnpOIL5TLc
 * TC : O(N)
 * SC : O(1)
 */
public class P_1470_Shuffle_the_Array {
    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        int n = 3;

        int[] res1 = approach1(nums, n);
        int[] res2 = approach2(nums, n);

        for (int x : res1) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (int x : res2) {
            System.out.print(x + " ");
        }
    }

    // TC : O(N) SC : O(N)
    private static int[] approach1(int[] nums, int n) {
        int[] arr = new int[nums.length];
        int jump = 0;

        for (int i = 0; i < n; i++) {
            arr[i + jump] = nums[i];
            arr[i + jump + 1] = nums[n + jump];
            jump++;
        }


        return arr;
    }

    // TC : O(N) SC : O(1)
    private static int[] approach2(int[] nums, int n) {
        for (int i = n; i < 2 * n; i++) {
            int secNum = nums[i] << 10;
            nums[i - n] = secNum | nums[i - n];
        }

        for (int i = n - 1; i >= 0; i--) {
            int secNum = nums[i] >> 10;
            int firstNum = nums[i] & 1023;

            nums[2 * i + 1] = secNum;
            nums[2 * i] = firstNum;
        }

        return nums;
    }

}
