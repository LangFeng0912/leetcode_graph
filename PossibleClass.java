import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PossibleClass {
    List<List<Integer>> resPath = new LinkedList<>();


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer>[] adj = new ArrayList[graph.length];
        for(int i = 0; i<graph.length; i++){
            adj[i] = new ArrayList<Integer>();
            for(int j = 0; j<graph[i].length; j++){
                adj[i].add(graph[i][j]);
            }
        }

        boolean[] visited = new boolean[adj.length];
        LinkedList<Integer> path = new LinkedList<Integer>();
        traverse(adj,visited,0,path);
        return resPath;


    }

    public void traverse(List<Integer>[] adj, boolean[] visited, int node, LinkedList<Integer> path){
        // if(visited[node]){
        //     return;
        // }
        // visited[node] = true;
        path.add(node);

        int l = adj.length;

        if(node == l-1){
            // System.out.println("yes");
            resPath.add(new LinkedList<>(path));
            // System.out.println(resPath);
            path.removeLast();
            return;
        }

        for(int neighbor: adj[node]){
            // System.out.println(neighbor);
            traverse(adj,visited,neighbor, path);
        }

        path.removeLast();


    }
}
