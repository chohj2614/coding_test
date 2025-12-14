import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Relation relation = new Relation(N);

        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            relation.addEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = N; i > 0; i--){
            int count = relation.BFS(i);
            min = Math.min(count, min);
            if(min == count){
                ans = i;
            }
        }

        System.out.println(ans);
    }

    public static class Relation{
        private int N;
        private LinkedList<Integer> adj[];

        Relation(int n){
            N = n;
            adj = new LinkedList[N+1];
            for(int i = 0; i <= N; i++){
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int n, int r){
            adj[n].add(r);
            adj[r].add(n);
        }

        int BFS(int n){
            boolean[] visited = new boolean[N+1];
            Queue<Integer> queue = new LinkedList<Integer>();
            int[] dist = new int[N + 1];
            Arrays.fill(dist, -1);

            visited[n] = true;
            dist[n] = 0;
            queue.add(n);
            while(!queue.isEmpty()){
                n = queue.poll();
                for(int i : adj[n]){
                    if(!visited[i]){
                        visited[i] = true;
                        dist[i] = dist[n] + 1;
                        queue.add(i);
                    }
                }
            }
            int sum = 0;
            for(int i =1; i <= N; i++){
                sum+= dist[i];
            }
            return sum ;
        }
    }
}