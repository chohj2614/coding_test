import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int MAX = 10000;
    static int[] dist = new int[MAX + 1];
    static int[] parent = new int[MAX];
    static char[] how = new char[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int target = Integer.parseInt(inputs[1]);

            BFS(start, target);
            System.out.println(recon(start,target));
        }
    }

    public static void BFS(int start, int target){
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == target) {
                return;
            }
            int d = (cur * 2) % 10000;
            int s = (cur == 0) ? 9999 : cur - 1;
            int l = (cur % 1000) * 10 + cur / 1000;
            int r = (cur % 10) * 1000 + cur / 10;

            if (dist[d] == -1) {
                dist[d] = dist[cur] + 1;
                parent[d] = cur;
                how[d] = 'D';
                queue.add(d);
            }
            if (dist[s] == -1) {
                dist[s] = dist[cur] + 1;
                parent[s] = cur;
                how[s] = 'S';
                queue.add(s);
            }
            if (dist[l] == -1) {
                dist[l] = dist[cur] + 1;
                parent[l] = cur;
                how[l] = 'L';
                queue.add(l);
            }
            if (dist[r] == -1) {
                dist[r] = dist[cur] + 1;
                parent[r] = cur;
                how[r] = 'R';
                queue.add(r);
            }
        }
    }

    static String recon(int start, int target){
        StringBuilder sb = new StringBuilder();
        while(target != start){
            sb.append(how[target]);
            target= parent[target];
        }
        sb.reverse();
        return sb.toString();
    }

}