package DP_basics;

import java.util.HashMap;

public class minChange {

    public static void main(String[] args) {
        
        int [] coins = {1,2,3};
        int amount = 534;

        System.out.println(minCoins(coins,amount));
    }

    public static int minCoins(int[] coins, int amount){
        
        return minCoins(coins, amount, new HashMap<>());
    }

    public static int minCoins(int[] coins, int amount, HashMap<Integer, Integer> memo){
        
        if(amount == 0)
            return 0;
        
        if(amount < 0)
            return -1;
        
        if(memo.containsKey(amount)){
            return memo.get(amount);
        }
        
        int minCoins = -1;
        
        for(int coin: coins){
            int remaining  = amount - coin;
            int tillNow = minCoins(coins, remaining, memo);
            if(tillNow >=0){
                int coins_tillNow = 1 + tillNow;
                if(coins_tillNow < minCoins || minCoins == -1)
                {
                    minCoins = coins_tillNow;
                }
            }

        }

        memo.put(amount, minCoins);

        return minCoins;
    }
    
}
