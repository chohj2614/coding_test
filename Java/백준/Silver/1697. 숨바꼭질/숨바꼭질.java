import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        Graph graph = new Graph(N,K);
        int time = graph.BFS();

        System.out.println(time);
    }

    public static class Graph{
        int N;
        int K;
        int MAX = 100000;

        Graph(int n, int k){
            N = n;
            K = k;
        }

        int BFS(){
            int x = N;
            int[] dist = new int[MAX + 1];
            boolean[] visited = new boolean[MAX + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(x);
            dist[x] = 0;
            visited[x] = true;

            while(!queue.isEmpty()){
                int cur = queue.poll();
                if(cur == K){
                    return dist[cur];
                }
                int[] nexts = {cur + 1, cur - 1, cur * 2};
                for(int next : nexts){
                    if(next <= MAX &&  next > -1 && !visited[next] ){
                        dist[next] = dist[cur] + 1;
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            return -1;
        }
    }
}