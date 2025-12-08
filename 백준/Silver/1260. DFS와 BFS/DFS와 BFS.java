import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sbDFS = new StringBuilder();
        StringBuilder sbBFS = new StringBuilder();
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int V = Integer.parseInt(inputs[2]);
        Graph graph = new Graph(N);

        for(int i = 0; i < M; i++){
            inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            graph.addEdge(n,m);
        }
        graph.sortAdj();
        graph.DFS(V,sbDFS);
        graph.BFS(V,sbBFS);
        System.out.println(sbDFS.toString());
        System.out.println(sbBFS.toString());
    }


    public static class Graph {
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v){
            V = v;
            adj = new LinkedList[v + 1];

            for(int i = 1; i <= v; i++){
                adj[i] = new LinkedList();
            }
        }

        void addEdge(int v, int w) {adj[v].add(w); adj[w].add(v);}

        // DFS
        void DFS(int v, StringBuilder sb){
            boolean visited[] = new boolean[V + 1];

            DFSUtil(v, visited, sb);
        }

        void DFSUtil(int v, boolean visited[], StringBuilder sb){
            visited[v] = true;
            sb.append(v).append(" ");

            Iterator<Integer> it = adj[v].listIterator();
            while(it.hasNext()){
                int n = it.next();
                if(!visited[n]){
                    DFSUtil(n,visited,sb);
                }
            }

        }

        void BFS(int v, StringBuilder sb){
            boolean visited[] = new boolean[V + 1];
            LinkedList<Integer> queue = new LinkedList<Integer>();

            visited[v] = true;
            queue.add(v);

            while (!queue.isEmpty()){
                v = queue.poll();
                sb.append(v).append(" ");

                Iterator<Integer> i = adj[v].listIterator();
                while(i.hasNext()){
                    int n = i.next();

                    if(!visited[n]){
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
        void sortAdj(){
            for(int i = 1 ; i <= V; i++){
                Collections.sort(adj[i]);
            }
        }
    }
}