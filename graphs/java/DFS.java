package linear_concepts.graphs.java;


import java.util.*;

public class DFS {

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("a", Arrays.asList("c", "b"));
        graph.put("b", Arrays.asList("d"));
        graph.put("c", Arrays.asList("e"));
        graph.put("d", Arrays.asList("f"));
        graph.put("e", new ArrayList<>());
        graph.put("f", new ArrayList<>());

        DFS_Print(graph, "a");

        System.out.println("---------------------------Recursive---------------------------------");
        DFS_Print_Recursive(graph, "a");
    }

    public static void DFS_Print(Map<String, List<String>> graph, String source) {
        Stack<String> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            String current = stack.pop();
            System.out.println(current);

            List<String> neighbors = graph.get(current);
            for (String neighbor : neighbors) {
                stack.push(neighbor);
            }
        }
    }

    public static void DFS_Print_Recursive(Map<String, List<String>> graph, String source){

        System.out.println(source);
        for(String neighbor: graph.get(source)){
            DFS_Print_Recursive(graph, neighbor);
        }
    }
}
