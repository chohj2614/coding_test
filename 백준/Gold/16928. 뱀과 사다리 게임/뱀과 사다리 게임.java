import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int ladder;
    static int snake;
    static final int max = 100;
    static int[] shortcuts = new int[max + 1];
    static int[] dist = new int[max + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        ladder = Integer.parseInt(input[0]); // 사다리 개수
        snake = Integer.parseInt(input[1]); // 뱀 개수
        Arrays.fill(dist, -1);

        // input 읽고 사다리, 뱀 위치 저장
        for(int i = 0; i < ladder + snake; i++){
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            shortcuts[start] = end;
        }
        BFS();

        System.out.println(dist[100]);
    }

    public static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 0;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            if(shortcuts[cur] != 0){
                dist[shortcuts[cur]] = dist[cur];
                cur = shortcuts[cur];
            }
            for(int i = 0; i < 7; i++){
                int next = cur + i;
                if(next <= 100 && dist[next] == -1){
                    queue.add(next);
                    dist[next] = dist[cur] + 1;
                }
            }
        }
    }
}