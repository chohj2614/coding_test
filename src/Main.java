import javax.swing.*;
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
        int M = Integer.parseInt(input[1]);
        int H = Integer.parseInt(input[2]);

        Boxes boxes = new Boxes(M,N,H);

        for(int i = 0; i < H; i++){
            for(int j = 0; j < M; j++){
                input = br.readLine().split(" ");
                int[] nums = new int[N];
                for(int k = 0; k < N; k++){
                    nums[k] = Integer.parseInt(input[k]);
                }
                boxes.fillBox(i,j,nums);
            }
        }
        for(int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (boxes.box[i][j][k] == 1){
                        boxes.BFS(i,j,k);
                    }
                }
            }
        }
        if(boxes.max < 0){
            System.out.println(-1);
        }else {
            System.out.println(boxes.max);
        }
    }

    public static class Boxes{
        int M;
        int N;
        int H;
        int[][][] box;
        int max;

        Boxes(int m, int n, int h){
            M = m;
            N = n;
            H = h;
            max = Integer.MIN_VALUE;
            box = new int[H][M][N]; //높이, 가로, 세로
        }

        void fillBox(int h, int m, int[] nums){
            for(int i = 0; i < N; i++){
                box[h][m][i] = nums[i];
            }
        }

        void BFS(int h, int m, int n){
            int[][] mv = {{1,0,0}, {-1,0,0}, {0,1,0}, {0,-1,0}, {0,0,1},{0,0,-1}};
            boolean[][][] visited = new boolean[H][M][N];
            int[][][] dist = new int[H][M][N];

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0,0});
            visited[h][m][n] = true;
            dist[h][m][n] = 0;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                for(int[] v: mv){
                    int nh = cur[0] + v[0];
                    int nx = cur[1] + v[1];
                    int ny = cur[2] + v[2];

                    if(nh < H && nh >= 0 && nx < M && nx >= 0 && ny < N && ny >= 0){
                        if(!visited[nh][nx][ny]){
                            if(box[nh][nx][ny] == -1){
                                queue.add(new int[]{nh,nx,ny});
                                visited[nh][nx][ny] = true;
                                dist[nh][nx][ny] = dist[cur[0]][cur[1]][cur[2]] + 1;
                            }
                        }
                    }
                }
            }
            for(int i = 0; i < H; i++){
                for(int j = 0; j < M; j++){
                    for(int x: dist[i][j]){
                        max = Math.max(max,x);
                    }
                }
            }
        }
    }
}