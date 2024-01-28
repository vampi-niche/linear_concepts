package DP_practice;

import java.util.Arrays;

public class fib_tabulate {

    public static void main(String[] args) {
        int n = 500;

        System.out.println(fib(n));
    }

    public static Long fib(int n){

        Long [] dp = new Long [n+1]; // to avoid index out of bound

        Arrays.fill(dp, 0l);

        dp[1] = 1l;

        // System.out.println(dp[2]);

        for(int i = 0; i<n-1; i++){
            dp[i+2] = dp[i+1] + dp[i];
        }

        return dp[n];
    }
    
}
