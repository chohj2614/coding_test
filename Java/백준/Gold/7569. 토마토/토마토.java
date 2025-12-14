import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int M,N,H;
    static int[][][] box;
    static int[][][] dist;
    static int[] dx = {1,-1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);
        box = new int[H][N][M];
        dist = new int[H][N][M];

        for(int h = 0; h < H; h++){
            for(int y = 0; y < N; y++){
                input = br.readLine().split(" "); // 각 줄 읽고 box에 넣기
                for(int x =0; x < M; x++){
                    box[h][y][x] = Integer.parseInt(input[x]);
                    if(box[h][y][x] == 0){
                        dist[h][y][x] = -1; // 방문해야 될 곳
                    } else {
                        dist[h][y][x] = 0; //
                    }
                }
            }
        }

        BFS();

        System.out.println(getResult());
    }
    
    public static void BFS(){
        Queue<int[]> queue = new LinkedList<>();
        for(int h = 0; h < H; h++){
            for(int y = 0; y < N; y++){
                for(int x =0; x < M; x++){
                    if(box[h][y][x] == 1){
                        queue.add(new int[]{h,y,x});
                        dist[h][y][x] = 0; // 익은 위치는 0으로 초기화
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int ch = cur[0];
            int cy = cur[1];
            int cx = cur[2];

            for(int i = 0; i < 6; i++){
                int nh = ch + dh[i];
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(nh < H && ny < N && nx < M && nh >= 0 && ny >= 0 && nx >= 0){
                    if(dist[nh][ny][nx] == -1){
                        if(box[nh][ny][nx] == 0){
                            queue.add(new int[]{nh, ny, nx});
                            dist[nh][ny][nx] = dist[ch][cy][cx] + 1;
                        }
                    }
                }
            }
        }
    }

    public static int getResult(){
        int max = Integer.MIN_VALUE;
        for(int h = 0; h < H; h++){
            for(int y = 0; y < N; y++){
                for(int x =0; x < M; x++){
                    max = Math.max(max, dist[h][y][x]);
                    if(dist[h][y][x] == -1){
                        return -1;
                    }
                }
            }
        }
        return max;
    }
}