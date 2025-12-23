import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for(int t =0; t < T; t++){
            String[] inputs = br.readLine().split(" ");
            int X = Integer.parseInt(inputs[0]);
            int Y = Integer.parseInt(inputs[1]);
            int K = Integer.parseInt(inputs[2]);
    
            Board brd = new Board(Y,X,K); // 새로운 보드 객체 생성
            for(int i = 0 ; i < K; i++){
                inputs = br.readLine().split(" ");
                int x = Integer.parseInt(inputs[0]);
                int y = Integer.parseInt(inputs[1]);
                brd.fillBoard(x,y); // 좌표에 배추 표시
            }
            
            int count = 0;
            for(int i = 0; i < X; i++){
                for(int j = 0; j < Y; j++){
                    if(brd.board[i][j] == 1 && !brd.visited[i][j]){ // 방문 안한 배추 찾기
                        brd.DFS(i,j); // 해당 배추의 인접 좌표 모두 방문 표시
                        count++; // 배추흰지렁이 개수++
                    }
                }
            }
            System.out.println(count);
        }
    } //main

    public static class Board{
        private int Y;
        private int X;
        private int K; // 좌표 개수
        private int[][] board; // 배추 유무 표시 지도
        private boolean[][] visited; // DFS 방문 표시용
        private int[][] mv = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 상하좌우 이동 방법
    
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
            visited[x][y] = true; // 해당 좌표 방문 표시
    
            if (board[x][y] == 1){ // 배추가 있는지 확인
                for(int[] v : mv){ // 상하좌우 체크 및 visited 처리
                    if(x + v[0] >= 0 && x + v[0] < X && y + v[1] >= 0 && y + v[1] < Y){ // 이동 목표가 좌표 내인지 확인
                        if(!visited[x+v[0]][y+v[1]]) { // 방문 기록 확인
                            DFS(x+v[0], y + v[1]); // 
                        }
                    }
                }
            }
        }
    } // board
}
