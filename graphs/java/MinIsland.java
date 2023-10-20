package linear_concepts.graphs.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MinIsland {

     public static List<List<String>> grid = new ArrayList<List<String>>();
    public static HashSet<String> visited = new HashSet<String>();

    public static void main(String[] args) {
        grid.add(Arrays.asList("w","l","w","w","w"));
        grid.add(Arrays.asList("w","l","w","w","w"));
        grid.add(Arrays.asList("w","w","w","l","w"));
        grid.add(Arrays.asList("w","w","l","l","w"));
        grid.add(Arrays.asList("l","w","w","l","l"));
        grid.add(Arrays.asList("l","l","w","w","w"));

        System.out.print(minIsland());
    }

    public static int minIsland(){

        int total_size = Integer.MAX_VALUE;

        HashMap<String,Integer> islandSize = new HashMap<String, Integer>();

        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.get(i).size();j++){
                if(grid.get(i).get(j).equals("l")){
                    int size = explore(i,j);
                    if(size > 0 ){
                        total_size = size < total_size ? size : total_size;
                        //create dictionary of sizes
                         String pos = Integer.toString(i) + "," + Integer.toString(j);
                        if(!islandSize.containsKey(pos)){
                            islandSize.put(pos, size);
                        }
                    }
                }
            }
        }

        System.out.println(islandSize);

        return total_size;
    }

    public static int explore(int i, int j){

        boolean rb = 0 <= i && i < grid.size();
        boolean cb = 0 <= j && j < grid.get(0).size();

        if( !rb || !cb || grid.get(i).get(j).equals("w")) return 0;

        String pos = Integer.toString(i) + "," + Integer.toString(j);

        if(visited.contains(pos)) return 0;

        visited.add(pos);

        int size = 1;

        size += explore(i+1, j);
        size += explore(i-1, j);
        size += explore(i, j+1);
        size += explore(i+1, j-1);

        return size;
    }
    
}
