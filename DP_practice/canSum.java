package DP_practice;

import java.util.Arrays;

public class canSum {

    public static void main(String[] args) {
        
        int [] numbers = {7,14};
        System.out.println(canit(300,numbers));
    }

    public static boolean canit(int target, int[] numbers){

        Boolean [] dp = new Boolean[target + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 0; i<= target; i++){
            // if(dp[i])
            for( int j = 0; j < numbers.length; j++){
                if(i+numbers[j] <=target) dp[i+numbers[j]] |= dp[i];
            }
        }

        return dp[target];
    }
    
}
