import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int MAX = 10000;
    static int[] dist = new int[MAX + 1];
    static StringBuilder[] hist = new StringBuilder[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int target = Integer.parseInt(inputs[1]);
            reset();
            BFS(start, target);
            System.out.println(hist[target]);
        }
    }

    public static void reset(){
        Arrays.fill(dist, -1);
        Arrays.setAll(hist, i -> new StringBuilder());
    }

    public static void BFS(int start, int target){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == target){
                return;
            }
            for(int i = 0; i < 4; i++){
                int next = 0;
                String s = "";
                switch (i){
                    case 0 :
                        s = "D";
                        next = D(cur);
                        break;
                    case 1 :
                        s = "S";
                        next = S(cur);
                        break;
                    case 2 :
                        s = "L";
                        next = L(cur);
                        break;
                    case 3 :
                        s = "R";
                        next = R(cur);
                        break;
                }
                if(dist[next] == -1){
                    hist[next] = new StringBuilder(hist[cur]).append(s);
                    dist[next] = dist[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }

    public static int D(int n){
        return (2*n) % 10000;
    }

    public static int S(int n){
        if(n == 0 ){
            return 9999;
        }
        return  n - 1;
    }

    public static int L(int n){
        return (n % 1000)*10 + n/1000;
    }

    public static int R(int n){
        return (n % 10) * 1000 + n / 10;
    }

}