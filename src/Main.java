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
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
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


        System.out.println();
    }

    public static class Boxes{
        int M;
        int N;
        int H;
        int[][][] box;

        Boxes(int m, int n, int h){
            M = m;
            N = n;
            H = h;
            box = new int[H][M][N]; //높이, 가로, 세로
        }

        void fillBox(int h, int m, int[] nums){
            for(int i = 0; i < N; i++){
                box[h][m][i] = nums[i];
            }
        }

        void BFS(){
            int[][] mv = {{1,0,0}, {-1,0,0}, {0,1,0}, {0,-1,0}, {0,0,1},{0,0,-1}};
            boolean[][][] visited = new boolean[H][M][N];
            int[][][] dist = new int[H][M][N];

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0,0});
            visited[0][0][0] = true;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();

            }
        }
    }
}