package DP_basics;

import java.util.HashMap;
import java.util.List;

public class maxPathSum {
    public static void main(String[] args) {
        List<List<Integer>> grid = List.of(
                List.of(1, 1, 3, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 2, 1, 1, 6, 1, 1, 5, 1, 1, 0, 0, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 5, 1, 1, 1, 1, 0, 1, 1, 1, 1),
                List.of(2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(2, 1, 1, 1, 1, 8, 1, 1, 1, 1, 1, 1, 1),
                List.of(2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 9, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 42, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        
        System.out.println(_maxPathSum(grid));
    }

    public static int _maxPathSum(List<List<Integer>> grid){
        int r = 0;
        int c = 0;
        return _maxPathSum(grid, r, c, new HashMap<>());
    }

    public static int _maxPathSum(List<List<Integer>> grid, int r, int c, HashMap<String, Integer> memo){


        if(r == grid.size() || c == grid.get(r).size()){
            return -1;
        }

        if(r== grid.size() - 1 && c == grid.get(r).size() - 1) {
            return grid.get(r).get(c);
        }

        String key = ""+r+","+c;

        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int sum_now = grid.get(r).get(c) + Math.max(_maxPathSum(grid, r, c+1, memo), _maxPathSum(grid, r+1, c, memo));

        memo.put(key, sum_now);

        return sum_now;

    }
}
