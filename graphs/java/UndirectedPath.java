package linear_concepts.graphs.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class UndirectedPath {

    public static void main(String[] args) {
        
       List<String[]> Edges = new ArrayList<String[]>();

       Edges.add(new String[]{"i","j"});
       Edges.add(new String[]{"k","i"});
       Edges.add(new String[]{"m","k"});
       Edges.add(new String[]{"k","l"});
       Edges.add(new String[]{"o","n"});
       
       Map <String, List<String>> graph =  buildGraph(Edges);

       Boolean result = undirectedPath(graph, "j", "m", new HashSet<String>());

       System.out.println(result);


    }

    public static Boolean undirectedPath(Map <String, List<String>> graph, String src, String dest, HashSet<String> visited){

        if(src.equals(dest))
            return true;
        
        if(visited.contains(src))
            return false;
        
        visited.add(src);

        for (String neighbor: graph.get(src)){

            if(undirectedPath(graph, neighbor, dest, visited))
                return true;
        }

        return false;
    }

    public static Map <String, List<String>> buildGraph(List<String[]> Edges){

        Map <String, List<String>> Graph = new HashMap<String, List<String>>();
        
        for (String[] edge: Edges){
            if(! Graph.containsKey(edge[0]))
                Graph.put(edge[0], new ArrayList<>());
            if(! Graph.containsKey(edge[1]))
                Graph.put(edge[1], new ArrayList<>());
            
            Graph.get(edge[0]).add(edge[1]);
            Graph.get(edge[1]).add(edge[0]);

        }

        return Graph;
    }

    
    
}
//  ['i','j'],
//     ['k','i'],
//     ['m','k'],
//     ['k','l'],
//     ['o','n']
