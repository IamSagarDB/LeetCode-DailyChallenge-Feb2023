import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        long A = 3;
        long res = 0;
        for(int i = 0 ; i < 32 ; i++){
            res = res<<1; // shift the res and OR append 0th index with lsb
            long lsb = A&1;
            res = res | lsb;
            A = A>>1;
        }

        System.out.println(res);
    }
}