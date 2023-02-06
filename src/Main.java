import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        int n = 3;

        for(int i = n ; i < 2*n ; i++){
            int secNum = nums[i] << 10;
            nums[i-n] = secNum | nums[i-n];
        }

        for (int i = n -1 ; i >=0 ; i--){
            int secNum = nums[i] >> 10;
            int firstNum = nums[i] & 1023;

            nums[2*i+1] = secNum;
            nums[2*i] = firstNum;
        }
    }
}