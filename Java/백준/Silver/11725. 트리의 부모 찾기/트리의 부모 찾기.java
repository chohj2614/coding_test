import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Graph graph = new Graph(N);
        for(int i = 0; i < N - 1; i++){
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph.addEdge(n,b);
        }
        graph.DFS(1);
        for(int i = 2; i <= N; i++){
            System.out.println(graph.parent[i]);
        }
    }

    public static class Graph{
        private int N;
        private LinkedList<Integer>[] adj;
        private int[] parent;
        private boolean[] visited;


        Graph(int n){
            N = n;
            adj = new LinkedList[N + 1];
            parent = new int[N + 1];
            visited = new boolean[N + 1];
            Arrays.fill(visited, Boolean.FALSE);

            for(int i = 0; i <= N; i++){
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int n, int b){
            adj[n].add(b);
            adj[b].add(n);
        }

        void DFS(int n){
            visited[n] = true;
            for(int a : adj[n]){
                if(!visited[a]){
                    parent[a] = n;
                    DFS(a);
                }
            }
        }
    }
}