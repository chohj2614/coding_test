import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");


        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Board brd = new Board(n,m);
        int sx = 0;
        int sy = 0;
        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");
            int[] nums = new int[m];
            for(int j = 0; j < m; j++){
                int temp = Integer.parseInt(input[j]);
                nums[j] = temp;
                if(temp == 2){
                    sx = i;
                    sy = j;
                }
            }
            brd.fillBoard(nums, i);
        }
        brd.BFS(sx, sy);
        for(int i = 0; i < n; i++){
            for(int x: brd.dist[i]){
                sb.append(x+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static class Board {
        int N;
        int M;
        int[][] board;
        int[][] dist;

        Board(int n, int m){
            N = n;
            M = m;
            board = new int[N][M];
            dist = new int[N][M];
            for(int i = 0; i < N; i++){
                Arrays.fill(dist[i], -1);
            }
        }

        void fillBoard(int[] nums, int row){
            for(int i =0; i < M; i++){
                board[row][i] = nums[i];
            }
        }

        void BFS(int sx, int sy){
            boolean[][] visited = new boolean[N][M];
            int[][] mv = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            dist[sx][sy] = 0;
            visited[sx][sy] = true;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{sx,sy});

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                for(int[] v : mv){
                    int nx = cur[0] + v[0];
                    int ny = cur[1] + v[1];
                    if(nx < N && nx > -1 && ny < M && ny > -1){
                        if(!visited[nx][ny]){
                            if(board[nx][ny] != 0){
                                queue.add(new int[]{nx,ny});
                                visited[nx][ny] = true;
                                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                            }
                        }
                    }
                }
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(board[i][j] == 0){
                        dist[i][j] = 0;
                    }
                }
            }
        }
    }
}

