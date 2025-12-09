import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int Y = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);

        Board brd = new Board(X,Y);

        for(int i = 0; i < X; i++){
            input = br.readLine().split(" ");
            int[] nums = new int[Y];
            for(int j= 0; j < Y; j++){
                nums[j] = Integer.parseInt(input[j]);
            }
            brd.fillBoard(nums, i);
        }
        brd.DFS(0,0);
        System.out.println(brd.reached);
    }
    public static class Board{
        private int X;
        private int Y;
        private LinkedList<Integer> board[];
        private boolean[][] visited;
        private String reached = "No";

        Board(int x, int y){
            X = x;
            Y = y;
            board  = new LinkedList[X];
            visited = new boolean[X][Y];
            for(int i = 0 ; i < X; i++){
                board[i] = new LinkedList<>();
                Arrays.fill(visited[i],Boolean.FALSE);
            }
        }

        void fillBoard(int[] nums, int row){
            for(int i = 0; i < Y; i++){
                board[row].add(nums[i]);
            }
        }

        void DFS(int sx, int sy){
            visited[sx][sy] = true;
            if(board[sx].get(sy) == 0){ // 벽
                return;
            }
            if(sx == X - 1 && sy == Y - 1) {
                reached = "Yes";
                return;
            }
            if(sx + 1 < X && !visited[sx+1][sy]){
                DFS(sx + 1,sy);
            }
            if(sy + 1 < Y && !visited[sx][sy + 1]){
                DFS(sx, sy + 1);
            }
        }
    }
}