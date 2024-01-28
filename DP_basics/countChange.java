package DP_basics;


// Write a function, countingChange, that takes in an amount and an array of coins. 
// The function should return the number of different ways it is possible to make change for the given amount using the coins.

// You may reuse a coin as many times as necessary.

public class countChange {

    public static void main(String[] args) {

        int [] coins  = {1,2,3,4};

        int res = countingChange(4,0, coins);

        System.out.println(res);
        
    }

    public static int countingChange(int target, int ind, int []coins){


        if (target == 0){
            return 1;
        }

        if( ind >= coins.length) return 0;

        int val = coins[ind];

        int ways = 0;

        for(int i = 0; i * val <= target; i++){

            int rem = target - (i * val);

            ways += countingChange(rem, ind+1, coins);

        }

        return ways;
    }
    
}
