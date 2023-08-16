package linear_concepts.graphs.java;

import java.util.*;
public class BFS {
    public static void main(String[] args){
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("a", Arrays.asList("c", "b"));
        graph.put("b", Arrays.asList("d"));
        graph.put("c", Arrays.asList("e"));
        graph.put("d", Arrays.asList("f"));
        graph.put("e", new ArrayList<>());
        graph.put("f", new ArrayList<>());

        BFS_Print(graph,"a");
    }

    public static void BFS_Print(Map<String,List<String>> graph, String source){

        Queue<String> queue = new LinkedList<String>();

        queue.offer(source);

        while(!queue.isEmpty()){
            String current = queue.poll();
            System.out.print(current);

            List<String> neighbors = graph.get(current);
            for (String neighbor: neighbors){
                queue.offer(neighbor);
            }
        }

    }
    
}
