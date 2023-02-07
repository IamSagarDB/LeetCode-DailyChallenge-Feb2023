/**
 * 904. Fruit Into Baskets
 *
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 *
 * Example 1:
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 *
 * Example 2:
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 *
 * Example 3:
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 *
 * Constraints:
 *
 * 1 <= fruits.length <= 105
 * 0 <= fruits[i] < fruits.length
 *
 * Time and Space Compexity
 * TC : O(N)
 * SC : O(1)
 */
public class P_904_Fruit_Into_Baskets {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int res = totalFruit(arr);
        System.out.println(res);
    }

    public static int totalFruit(int[] fruits) {
        int max = 0;
        int current_max = 0;
        int last_fruit = -1;
        int second_last_fruit = 0;
        int last_fruit_count = 0;

        for (int fruit : fruits){
            if ((fruit == last_fruit) || (fruit == second_last_fruit)){
                current_max++;
            }else {
                current_max = last_fruit_count + 1;
            }

            if (fruit == last_fruit){
                last_fruit_count ++;
            }else {
                last_fruit_count = 1;
            }

            if (fruit != last_fruit) {
                second_last_fruit = last_fruit;
                last_fruit = fruit;
            }

            max = Math.max(current_max, max);
        }
        return max;
    }
}
