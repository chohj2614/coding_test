import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int M, N;
    static int[][] box;
    static int[][] dist;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        box = new int[N][M];
        dist = new int[N][M];

        for(int y = 0; y < N; y++){
            input = br.readLine().split(" ");
            for(int x = 0; x < M; x++){
                box[y][x] = Integer.parseInt(input[x]); //
                if(box[y][x] == 0){ // 익지 않은 위치는 -1 로 초기화
                    dist[y][x] = -1;
                }
            }
        }

        BFS();

        System.out.println(getResult());
    }

    public static void BFS(){
        Queue<int[]> queue = new LinkedList<>();
        for(int y = 0; y < N; y++){
            for(int x = 0; x <M; x++){
                if(box[y][x] == 1){
                    queue.add(new int[]{y,x});
                    dist[y][x] = 0;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            for(int i =0 ; i < 4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny < N && nx < M &&  ny >= 0 && nx >= 0){ // 범위 확인
                    if(box[ny][nx] == 0){ // 익지 않은 위치 확인
                        if(dist[ny][nx] == -1){
                            queue.add(new int[] {ny, nx});
                            dist[ny][nx] = dist[cy][cx] + 1;
                        }
                    }
                }
            }
        }
    }

    public static int getResult(){
        int max = Integer.MIN_VALUE;
        for(int y = 0; y < N; y++){
            for(int x = 0; x < M; x++){
                int cur = dist[y][x];
                if(cur == -1){
                    return -1;
                }
                max = Math.max(cur, max);
            }
        }
        return max;
    }
}