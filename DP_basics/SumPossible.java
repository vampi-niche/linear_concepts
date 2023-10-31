package DP_basics;

import java.util.HashMap;

public class SumPossible {
    public static void main(String[] args) {
        
        int sum = 5641;
        int [] nums = {2,5};

        System.out.println(sumPossible(nums, sum));
    }

    public static boolean sumPossible(int[] nums, int sum){
        return sumPossible(nums, sum, new HashMap<>());
    }

    public static boolean sumPossible(int[] nums, int sum, HashMap<Integer, Boolean> memo){

        if(sum == 0){
            return true;
        }
        if(sum < 0){
            return false;
        }
        if(memo.containsKey(sum))
        return memo.get(sum);

        for(int num: nums){
            int subSum = sum - num;
            if (sumPossible(nums, subSum, memo)){
                memo.put(sum, true);
                return true;
            }
        }
        memo.put(sum, false);
        return false;
    }
}
