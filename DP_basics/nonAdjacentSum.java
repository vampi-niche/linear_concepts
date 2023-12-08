package DP_basics;

import java.util.HashMap;
import java.util.List;

public class nonAdjacentSum {

    public static void main(String[] args) {
        
        List<Integer> nums = List.of(
                72, 62, 10, 6, 20, 19, 42, 46, 24, 78,
                30, 41, 75, 38, 23, 28, 66, 55, 12, 17,
                83, 80, 56, 68, 6, 22, 56, 96, 77, 98,
                61, 20, 0, 76, 53, 74, 8, 22, 92, 37,
                30, 41, 75, 38, 23, 28, 66, 55, 12, 17,
                72, 62, 10, 6, 20, 19, 42, 46, 24, 78,
                42);

        System.out.println(sumIt(nums));
    }

    public static int sumIt(List<Integer> nums){

        return sumIts(nums, 0, new HashMap<>());

    }

    public static int sumIts(List<Integer> nums, int starting, HashMap<Integer, Integer>memo){

        if(starting >= nums.size()){
            return 0;
        }

        if(memo.containsKey(starting)){
            return memo.get(starting);
        }

        int sum_tillNow =  Math.max(nums.get(starting) + sumIts(nums, starting+2, memo), sumIts(nums, starting + 1, memo));
        
        memo.put(starting, sum_tillNow);
        return sum_tillNow;
    }
    
}
