import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Board game = new Board(N);

        for(int i = 0; i < N; i++){
            String[] inputs = br.readLine().split(" ");
            int[] nums = new int[N];
            for(int j = 0; j < N; j++){
                nums[j] = Integer.parseInt(inputs[j]);
            }
            game.makeBoard(nums, i);
        }
        game.DFS(0,0);
        if(game.found){
            System.out.println("HaruHaru");
        }else{
            System.out.println("Hing");
        }
    }
    public static class Board{
        private int N;
        private LinkedList<Integer> board[];
        private Boolean[][] visited;

        private boolean found = false;

        Board(int n){
            N = n;
            board = new LinkedList[N];
            visited = new Boolean[N][N];
            for(int i = 0; i < N; i++){
                board[i] = new LinkedList<>();
                Arrays.fill(visited[i], Boolean.FALSE);
            }
        }

        void makeBoard(int[] inputs, int row){
            for(int i = 0; i < N; i++){
                board[row].add(inputs[i]);
            }
        }

        void DFS(int sx, int sy){
            visited[sx][sy] =  true;
            int mv = board[sx].get(sy);

            if(mv == -1){
                found = true;
                return;
            }
            if(mv + sx < N && !visited[mv+sx][sy]){
                DFS(sx+mv, sy);
            }
            if(mv + sy < N && !visited[sx][sy + mv]){
                DFS(sx, sy + mv);
            }
        }
    }
}