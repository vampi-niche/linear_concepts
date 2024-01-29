package DP_practice;

import java.util.Arrays;

public class gridTravel {

    public static void main(String[] args) {
        System.out.println(travel(18,18));
    }

    public static Long travel(int m, int n){

        Long [][] dp = new Long[m+1][n+1];

        for(Long[] i : dp)
            Arrays.fill(i, 0l);

        dp[1][1] = 1l;

        for(int i=0;i<=m;i++)
            for(int j=0;j<=n;j++){
                if(i+1 <= m) dp[i+1][j] += dp[i][j];
                if(j+1 <= n) dp[i][j+1] += dp[i][j];

            }

        
        return dp[m][n];

    }
    
}
