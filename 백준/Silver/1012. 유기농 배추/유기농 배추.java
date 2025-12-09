import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t =0; t < T; t++){
            String[] inputs = br.readLine().split(" ");
            int X = Integer.parseInt(inputs[0]);
            int Y = Integer.parseInt(inputs[1]);
            int K = Integer.parseInt(inputs[2]);

            Board brd = new Board(Y,X,K);
            for(int i = 0 ; i < K; i++){
                inputs = br.readLine().split(" ");
                int x = Integer.parseInt(inputs[0]);
                int y = Integer.parseInt(inputs[1]);
                brd.fillBoard(x,y);
            }
            int count = 0;
            for(int i = 0; i < X; i++){
                for(int j = 0; j < Y; j++){
                    if(brd.board[i][j] == 1 && !brd.visited[i][j]){
                        brd.DFS(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static class Board{
        private int Y;
        private int X;
        private int K;
        private int[][] board;
        private boolean[][] visited;
        private int[][] mv = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Board(int y, int x, int k){
            Y = y;
            X = x;
            K = k;
            board = new int[X][Y];
            visited = new boolean[X][Y];
            for(int i =0; i < X; i++){
                Arrays.fill(visited[i], Boolean.FALSE);
            }
        }

        void fillBoard(int x, int y){
            board[x][y] = 1;
        }

        void DFS(int x, int y){
            visited[x][y] = true;

            if (board[x][y] == 1){
                for(int[] v : mv){ // 상하좌우 체크 및 visited 처리
                    if(x + v[0] >= 0 && x + v[0] < X && y + v[1] >= 0 && y + v[1] < Y){
                        if(!visited[x+v[0]][y+v[1]]) {
                            DFS(x+v[0], y + v[1]);
                        }
                    }
                }
            }
        }
    }
}