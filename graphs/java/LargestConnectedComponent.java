package linear_concepts.graphs.java;
/*graph = {
    0: [8,1,5],
    1: [0],
    5: [0,8],
    8: [0,5],
    2: [3,4],
    3: [2,4],
    4: [3,2]
} */
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestConnectedComponent {

    public static void main(String[] args) {

        Map<Integer,List<Integer>> graph = new HashMap<Integer,List<Integer>>();
        graph.put(0, Arrays.asList(8,1,5));
        graph.put(1, Arrays.asList(0));
        graph.put(5, Arrays.asList(0,8));
        graph.put(8, Arrays.asList(0,5));
        graph.put(2, Arrays.asList(3,4));
        graph.put(3, Arrays.asList(2,4));
        graph.put(4, Arrays.asList(3,2));

        int maxComponentSize = getMaxComponentSize(graph);
        System.out.println(maxComponentSize);
        
        
    }

    public static int getMaxComponentSize(Map<Integer,List<Integer>> graph){
        
        Set<Integer> visited = new HashSet<Integer>();
        int max = 0;
        for (Integer node : graph.keySet()) {
            
            int traverseResult = traverse(graph, node, visited);

            if(traverseResult> max)
                max = traverseResult;              

        }       

        return max;
    }
    
    public static int traverse(Map<Integer,List<Integer>> graph, Integer node, Set<Integer> visited){

        if(visited.contains(node)){
            return 0;
        }

        int size = 1;
        visited.add(node);

        for (Integer neighbor: graph.get(node)){
            size += traverse(graph, neighbor, visited);
        }

        return size;
    }
}
