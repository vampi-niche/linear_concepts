package linear_concepts.graphs.java;

import java.util.*;

public class hasPath {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("f", Arrays.asList("g", "i"));
        graph.put("g", Arrays.asList("h"));
        graph.put("h", new ArrayList<>());
        graph.put("i", Arrays.asList("g","k"));
        graph.put("j", Arrays.asList("i"));
        graph.put("k", new ArrayList<>());

        System.out.println(hasPath_DFS(graph, "f", "k"));

        System.out.println("---------------------------Recursive---------------------------------");
        System.out.println(hasPath_DFS_Recursive(graph, "f","k"));
        System.out.println("---------------------------BFS---------------------------------");
        System.out.println(hasPath_BFS(graph, "f","k"));


    }

    public static boolean hasPath_DFS(Map<String, List<String>> graph, String source, String Dest) {

        Stack<String> stack = new Stack<String>();
        stack.push(source);

        while(!stack.isEmpty()){
            String current = stack.pop();
            if(current.equals(Dest))
                return true;
            
            List<String> neighbors = graph.get(current);

            for (String neighbor: neighbors){
                stack.push(neighbor);
            }
        }
        return false;
        
    }
    
    public static boolean hasPath_DFS_Recursive(Map<String, List<String>> graph, String source, String Dest){
        if (source.equals(Dest))
            return true;
        for(String neighbor: graph.get(source)){
            if(hasPath_DFS_Recursive(graph, neighbor, Dest))
                return true;
        }
        return false;
    }
    public static boolean hasPath_BFS(Map<String, List<String>> graph, String source, String Dest) {

        Queue<String> queue = new LinkedList<String>();
        queue.offer(source);
        while(!queue.isEmpty()){
            String current = queue.poll();
            if(current.equals(Dest))
                return true;
            List<String> neighbors = graph.get(current);
            for(String neighbor: neighbors){
                queue.offer(neighbor);
            }
        }
        return false;
    }

}
