import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int compN = Integer.parseInt(br.readLine());
        int edgeN = Integer.parseInt(br.readLine());

        Graph graph = new Graph(compN);
        for(int i = 0; i < edgeN; i++){
            String[] newInput = br.readLine().split(" ");
            int v = Integer.parseInt(newInput[0]);
            int w = Integer.parseInt(newInput[1]);
            graph.addEdge(v,w);
        }

        graph.DFS(1);
        System.out.println(graph.count);
    }

    public static class Graph{
        private int V;
        private LinkedList<Integer> adj[];
        private boolean[] visited;
        private int count;

        Graph(int v){
            V = v;
            count = 0;
            adj = new LinkedList[v + 1];
            for(int i = 1; i <= v; i++){
                adj[i] = new LinkedList();
            }
            visited = new boolean[V + 1];
        }

        void addEdge(int v, int w){
            adj[v].add(w);
            adj[w].add(v);
        }

        void DFS(int v){
            visited[v] = true;

            for(int next: adj[v]){
                if(!visited[next]){
                    count++;
                    DFS(next);
                }
            }

        }
    }
}