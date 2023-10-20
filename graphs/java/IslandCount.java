package linear_concepts.graphs.java;
/*const grid = [
    ["w","l","w","w","w"],
    ["w","l","w","w","w"],
    ["w","w","w","l","w"],
    ["w","w","l","l","w"],
    ["l","w","w","l","l"],
    ["l","l","w","w","w"]
] */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class IslandCount {

    public static List<List<String>> grid = new ArrayList<List<String>>();
    public static HashSet<String> visited = new HashSet<String>();

    public static void main(String[] args) {
        grid.add(Arrays.asList("w","l","w","w","w"));
        grid.add(Arrays.asList("w","l","w","w","w"));
        grid.add(Arrays.asList("w","w","w","l","w"));
        grid.add(Arrays.asList("w","w","l","l","w"));
        grid.add(Arrays.asList("l","w","w","l","l"));
        grid.add(Arrays.asList("l","l","w","w","w"));

        System.out.print(islandCout());

    }

    public static int islandCout(){

        int count = 0;

        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.get(i).size();j++){
                
                if(grid.get(i).get(j).equals("l")){
                    if(explore(i,j))
                        count++;
                }
            }
        }

        return count;
    }

    public static boolean explore(int i, int j){

        boolean rb = 0 <= i && i<grid.size();
        boolean cb = 0 <= j && j<grid.get(0).size();
        
        if( !rb || !cb || grid.get(i).get(j).equals("w")) return false;

        String pos = Integer.toString(i)+","+Integer.toString(j);

        if(visited.contains(pos)) return false;

        visited.add(pos);

        explore(i-1, j);
        explore(i+1, j);
        explore(i, j-1);
        explore(i, j+1);



        return true;
    }
    
    
}
