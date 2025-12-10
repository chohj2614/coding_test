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
            queue.add(new int[]{0,0}); // Queue 안에 int[] 를 넣을 때는 명시적 배열로 넣음
            visited[0][0] = true; // 시작 위치 방문 표시
            int[][] dist = new int[N][M];
            int[][] mv = {{0,1}, {0,-1}, {1,0}, {-1, 0}}; // 상하좌우 이동
            dist[0][0] = 1; // *** 미로 문제 시작점은 1 ***

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                for(int[] v : mv){
                    int nx = cur[0] + v[0];
                    int ny = cur[1] + v[1];
                    // 이동 위치 validity 체크
                    if(nx < N && nx > -1 && ny < M && ny > -1){
                        if(board[nx][ny] != 0){ // 벽이 아닌지 확인
                            if(!visited[nx][ny]){ // 방문 여부 확인
                                queue.add(new int[]{nx,ny}); // queue 에 넣기
                                visited[nx][ny] = true; // 방문 표시
                                dist[nx][ny] = dist[cur[0]][cur[1]] + 1; // dist 업데이트
                            }
                        }
                    }
                }
            }
            return dist[N - 1][M - 1];
        }
    }
}