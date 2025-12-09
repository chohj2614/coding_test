import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Graph graph = new Graph(N);

        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            graph.addEdge(n,c);
        }
        int count = 0;
        for(int i = 1; i <= N; i++){
            if(!graph.visited[i]){
                graph.DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static class Graph{
        private int N;
        private LinkedList<Integer> adj[];
        private boolean[] visited;

        Graph(int n){
            N = n;
            adj = new LinkedList[N + 1];
            visited = new boolean[N + 1];
            Arrays.fill(visited,Boolean.FALSE);
            for(int i = 0; i <= N; i++){
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int r, int c){
            adj[r].add(c);
            adj[c].add(r);
        }

        void DFS(int n){
            visited[n] = true;
            for(int b: adj[n]){
                if(!visited[b]){
                    DFS(b);
                }
            }

        }
    }
}