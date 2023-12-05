package DP_basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class count_n_tracePaths {
    public static List<String> paths= new ArrayList<>();

    public static void main(String[] args) {
        
        List<List<String>> grid = List.of(
            List.of("O", "O", "X"),
            List.of("O", "O", "O"),
            List.of("O", "O", "O")
          );


        System.out.println(""+grid.size() +","+ grid.get(0).size());

        System.out.println(count_paths(grid, "0,0", ""));
        
        for(String s: paths){
            System.out.println(s);
        }

        

        
    }     

    public static int count_paths(List<List<String>> grid, String starting , String pathString){
        
         int r = Integer.parseInt(starting.split(",")[0]);
        int c = Integer.parseInt(starting.split(",")[1]);
        return count_paths(grid, r, c,new HashMap<>(), pathString);
    }

    public static int count_paths(List<List<String>> grid, int r, int c, HashMap<String, String> memo, String pathString){
        
       
        if(r == grid.size() || c == grid.get(0).size() || grid.get(r).get(c) == "X"){
            
            return -1;

        }
        pathString+="("+r+","+c+")";

        if(r == grid.size() -1 && c == grid.get(0).size() -1){
            System.out.println("reached!");
            System.out.println("adding "+ pathString);
            paths.add(pathString);
            return 1;
        }

        if(memo.containsKey(""+r+","+c)){
            System.out.println(pathString+"___before");
            pathString += memo.get(""+r+","+c).split(":")[0];
            System.out.println(pathString+"____after");

            return Integer.parseInt(memo.get(""+r+","+c).split(":")[1]);
        }

        int paths = 0;

        int down = count_paths(grid, r+1, c, memo, pathString+"->");

        if(down > -1) {paths += down;
            // pathString += "("+r+","+c+")->";
            
        }
        
        int right = count_paths(grid, r, c+1, memo, pathString+"->");

        if(right > -1) {paths += right;
        // pathString += "("+r+","+c+")->";
        }

        memo.put(""+r+","+c, pathString+":"+paths);
        return paths;
      
    }
    
}
