import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Board brd = new Board();

        for(int i = 0; i < 5; i++){
            String[] newInput = br.readLine().split(" ");
            int[] nums = new int[5];
            for(int j = 0; j < 5; j++){
                nums[j] = Integer.parseInt(newInput[j]);
            }
            brd.fillBoard(nums,i);
        }

        String[] newInput = br.readLine().split(" ");
        int r = Integer.parseInt(newInput[0]);
        int c = Integer.parseInt(newInput[1]);

        brd.DFS(r,c);

        System.out.println(brd.possible);
    }

    public static class Board{
        private LinkedList<Integer> board[];
        private int mv_count = 0;
        private int app_count = 0;
        private int possible = 0;
        private int[][] mv = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

        Board(){
            board = new LinkedList[5];
            for(int i = 0; i < 5; i++){
                board[i] = new LinkedList<>();
            }
        }

        void fillBoard(int[] nums, int row){
            for(int i =0; i < 5; i++){
                board[row].add(nums[i]);
            }
        }

        void DFS(int r, int c){
            if(mv_count> 3){
                mv_count--;
                return;
            }
            int cur = board[r].get(c);

            // 사과 확인
            if(cur == 1){
                app_count++;
                if(app_count >=2){
                    possible = 1;
                }
            }
            // 현재 위치를 장애물로 표시
            board[r].set(c, -1);

            for(int[] v : mv){
                if(r + v[0] < 5 && r+v[0] >= 0 && c + v[1] < 5 && c + v[1] >= 0){
                    if(board[r+v[0]].get(c+v[1]) != -1){
                        mv_count++;
                        DFS(r + v[0], c + v[1]);
                    }
                }
            }
            board[r].set(c,cur); // 현재 위치 재설정
            mv_count--;
            if(cur == 1){
                app_count--;
            }
        }
    }
}