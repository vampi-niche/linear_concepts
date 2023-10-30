package DP_basics;

import java.util.HashMap;

public class Fib{
    public static void main(String[] args) {
        
        System.out.print(fib(64));

    }

    public static int fib(int n){


        return  fib(n, new HashMap<>());

    }

    public static int fib (int n, HashMap<Integer, Integer> memo){

        if(n == 0 || n == 1) return n;

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int hold = fib(n-1, memo) + fib(n-2, memo);

        memo.put(n, hold);

        return hold;

    }
}