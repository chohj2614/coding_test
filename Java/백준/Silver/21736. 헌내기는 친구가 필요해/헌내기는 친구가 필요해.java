import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int sx = 0;
        int sy = 0;
        Campus camp = new Campus(N,M);
        for(int i = 0; i < N; i++){
            char[] inputs = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                if (inputs[j] == 'I'){
                    sx = i;
                    sy = j;
                }
            }
            camp.setCampus(inputs, i);
        }
        int count = camp.DFS(sx,sy,0);
        if(count == 0){
            System.out.println("TT");
        }else {
            System.out.println(count);
        }
    }

    public static class Campus{
        private int N;
        private int M;
        private char[][] campus;
        private boolean[][] visited;
        private int[][] mv = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        Campus(int n, int m){
            N = n;
            M = m;
            campus = new char[N][M];
            visited = new boolean[N][M];
            for(int i = 0; i < N; i++){
                Arrays.fill(visited[i], Boolean.FALSE);
            }
        }
        void setCampus(char[] chars, int row){
            for(int i = 0; i < M; i++){
                campus[row][i] = chars[i];
            }
        }

        int DFS(int sx, int sy, int count){
            visited[sx][sy] = true;
            if(campus[sx][sy] == 'P'){ //사람 있는지 확인
                count += 1;
            }
            for(int[] v : mv){ //상하좌우 이동
                //캠퍼스 내인지 확인
                if(sx + v[0] < N && sx + v[0] > -1 && sy + v[1] < M && sy + v[1] > -1){
                    if(!visited[sx+v[0]][sy + v[1]]) { // 방문 없는 지점 확인
                        if(campus[sx+v[0]][sy+v[1]] != 'X'){ // 벽 아닌지 확인
                            count = DFS(sx + v[0], sy + v[1], count);
                        }
                    }
                }
            }
            return count;
        }
    }
}