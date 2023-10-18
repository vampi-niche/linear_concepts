package linear_concepts.graphs.java;


/*const edges = [
    ['w','x'],
    ['x','y'],
    ['z','y'],
    ['z','v'],
    ['w','v'],

] */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPath {
    public static void main(String[] args) {
    
        List<List<String>> edges = new ArrayList<List<String>>();

        edges.add(Arrays.asList("w","x"));
        edges.add(Arrays.asList("x","y"));
        edges.add(Arrays.asList("z","y"));
        edges.add(Arrays.asList("z","v"));
        edges.add(Arrays.asList("w","v"));

        Map<String, List<String>> graph;

        graph = buildGraph(edges);

        int result = shortestPath(graph, "w", "z");


        System.out.println(result);

    }

    public static int shortestPath(Map<String, List<String>> graph, String src, String dest){

        Set<String> visited = new HashSet<String>();
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.offer(new GraphNode(src, 0));
        
        visited.add(src);

        while(!queue.isEmpty()){
            GraphNode currNode = queue.poll();

            if(currNode.Node.equals(dest)) return currNode.distance;

            for(String neighbor:graph.get(currNode.Node)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.offer(new GraphNode(neighbor, currNode.distance + 1));

                }
            }
        }

        return -1;
    }

    public static Map<String, List<String>> buildGraph( List<List<String>> edges){

        Map<String, List<String>> graph = new HashMap<String, List<String>>();

        for(List<String> edge:edges){
            String a = edge.get(0);
            String b = edge.get(1);

            if(!graph.containsKey(a)) graph.put(a, new ArrayList<>());
            if(!graph.containsKey(b)) graph.put(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

     
        return graph;
    }

    private static class GraphNode{
        String Node;
        Integer distance;

        GraphNode(String Node, Integer distance){
            this.Node = Node;
            this.distance = distance;
        }
    }
    
}
