import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 보드 NxM 받아오기
        String[] newLine = br.readLine().split(" ");
        int N = Integer.parseInt(newLine[0]);
        int M = Integer.parseInt(newLine[1]);

        // 보드 스트링으로 저장
        List<String> board = new ArrayList<>();
        for(int i = 0; i < N; i++){
            board.add(br.readLine());
        }

        int min = Integer.MAX_VALUE;
        // 시작 지점 Iteration
        for(int x = 0; x < N - 7; x++){
            for(int y = 0; y < M - 7; y++) {
                int count = countChange(x, y, board);
                min = Math.min(min, count);
            }
        }
        System.out.println(min);
    }
    static int countChange(int sx, int sy, List<String> board){
        int min = Integer.MAX_VALUE;
        //시작이 W or B -> 2번
        for(int i = 0; i < 2; i++){
            int count = 0;
            char prev = i == 0? 'W' : 'B';
            for(int x = sx; x < sx + 8; x++){
                String currLine = board.get(x);
                prev = opposite(prev);
                char cur = prev;
                for(int y = sy; y < sy+ 8; y++){
                    if(currLine.charAt(y) != cur){
                        count++;
                    }
                    cur = opposite(cur);
                }
            }
            min = Math.min(min, count);
        }
        return min;
    }
    static char opposite(char c){
        return (c == 'W') ? 'B' : 'W';
    }
}