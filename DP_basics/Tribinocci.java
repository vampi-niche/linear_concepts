package DP_basics;

import java.util.HashMap;

public class Tribinocci {
    public static void main(String[] args) {
        
        System.out.print(trib(64));

    }

    public static int trib(int n){


        return  trib(n, new HashMap<>());

    }

    public static int trib (int n, HashMap<Integer, Integer> memo){

        if(n == 0 || n == 1) return n;

        if(n == 2) return 1;

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int hold = trib(n-1, memo) + trib(n-2, memo) + trib(n-3, memo);

        memo.put(n, hold);

        return hold;

    }
}
