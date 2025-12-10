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
        Board brd = new Board(N,M);

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            int[] nums = new int[M];
            for(int j = 0; j < M; j++){
                nums[j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
            brd .fillBoard(nums,i);
        }
        int dist = brd.BFS();
        System.out.println(dist);
    }

    public static class Board{
        private int N;
        private int M;
        private int[][] board;
        private boolean[][] visited;

        Board(int n, int m){
            N = n;
            M = m;
            board = new int[N][M];
            visited = new boolean[N][M];
        }

        void fillBoard(int[] nums, int row){
            for(int i = 0; i < M; i++){
                board[row][i] = nums[i];
            }
        }

        int BFS(){
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0});
            visited[0][0] = true;
            int[][] dist = new int[N][M];
            int[][] mv = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
            dist[0][0] = 1;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                for(int[] v : mv){
                    int nx = cur[0] + v[0];
                    int ny = cur[1] + v[1];
                    if(nx < N && nx > -1 && ny < M && ny > -1){
                        if(board[nx][ny] != 0){
                            if(!visited[nx][ny]){
                                queue.add(new int[]{nx,ny});
                                visited[nx][ny] = true;
                                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                            }
                        }
                    }
                }
            }
            return dist[N - 1][M - 1];
        }
    }
}