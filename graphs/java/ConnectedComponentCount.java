package linear_concepts.graphs.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConnectedComponentCount {
    public static void main(String[] args) {
    
        Map<Integer,List<Integer>> graph = new HashMap<Integer,List<Integer>>();

        graph.put(3,new ArrayList<>());
        graph.put(4,Arrays.asList(6));
        graph.put(6,Arrays.asList(4,5,7,8));
        graph.put(8,Arrays.asList(6));
        graph.put(7,Arrays.asList(6));
        graph.put(5,Arrays.asList(6));
        graph.put(2,Arrays.asList(1));
        graph.put(1,Arrays.asList(2));

        System.out.println(countConnectedComponents(graph));
        
    }

    public static int countConnectedComponents(Map<Integer,List<Integer>> graph){
        int count =0;
        Set<Integer> visited = new HashSet<Integer>();

        for (Integer node : graph.keySet()) {

            if(traverse(graph, node, visited))
                count++;
            
        }


        return count;
    }
    
    public static boolean traverse(Map<Integer,List<Integer>> graph, Integer node, Set<Integer> visited){

        if(visited.contains(node))
            return false;
        visited.add(node);

        for (Integer neighbor : graph.get(node)) {
            traverse(graph, neighbor, visited);       
        }

        return true;
    }
}

/*graph = {
    3: [],
    4: [6],
    6: [4, 5, 7, 8],
    8: [6],
    7: [6],
    5: [6],
    1: [2],
    2: [1]
} */
