package DP_basics;

import java.util.HashMap;
import java.util.List;

public class countPaths {

    public static void main(String[] args) {
        
        List<List<String>> grid = List.of(
  List.of("O", "O", "X", "X", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"),
  List.of("O", "O", "X", "X", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"),
  List.of("O", "O", "O", "X", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"),
  List.of("X", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"),
  List.of("X", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "X", "X", "O"),
  List.of("O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "X", "O"),
  List.of("O", "O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O"),
  List.of("X", "X", "X", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O"),
  List.of("O", "O", "O", "O", "X", "X", "O", "O", "O", "O", "X", "O", "O", "O", "O"),
  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
  List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
  List.of("O", "O", "O", "O", "X", "X", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
  List.of("O", "O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O"),
  List.of("O", "O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O")
);


        System.out.println(""+grid.size() +","+ grid.get(0).size());

        System.out.println(count_paths(grid, "0,0"));

        
    }     

    public static int count_paths(List<List<String>> grid, String starting){
        
         int r = Integer.parseInt(starting.split(",")[0]);
        int c = Integer.parseInt(starting.split(",")[1]);
        return count_paths(grid, r, c,new HashMap<>());
    }

    public static int count_paths(List<List<String>> grid, int r, int c, HashMap<String, Integer> memo){
        
       
        if(r == grid.size() || c == grid.get(0).size() || grid.get(r).get(c) == "X"){
            return -1;
        }

        if(r == grid.size() -1 && c == grid.get(0).size() -1){
            System.out.println("reached!");
            return 1;
        }

        if(memo.containsKey(""+r+","+c)){
            return memo.get(""+r+","+c);
        }

        int paths = 0;

        int down = count_paths(grid, r+1, c, memo);

        if(down > -1) paths += down;
        
        int right = count_paths(grid, r, c+1, memo);

        if(right > -1) paths += right;

        memo.put(""+r+","+c, paths);
        return paths;
      
    }
        

    
}
