import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Drawing drawing = new Drawing(N);

        for(int i =0 ; i < N; i++){
            char[] chars = br.readLine().toCharArray();
            drawing.fillDrawing(chars, i);
        }
        int cb_count = 0;
        int norm_count = 0;
        for(int x = 0; x < N; x++){
            for(int y = 0; y < N; y++){
                if(!drawing.visited[x][y]){
                    drawing.DFS(x,y,false);
                    norm_count++;
                }
            }
        }
        drawing.resetDrawing();
        for(int x = 0; x < N; x++){
            for(int y = 0; y < N; y++){
                if(!drawing.visited[x][y]){
                    drawing.DFS(x,y,true);
                    cb_count++;
                }
            }
        }

        System.out.println(norm_count + " " + cb_count);
    }

    public static class Drawing{
        private int N;
        private boolean[][] visited;
        private char[][] dMap;
        private int count;
        private int[][] mv = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        Drawing(int n){
            N = n;
            visited = new boolean[N][N];
            dMap = new char[N][N];
            for(int i=0; i < N; i++){
                Arrays.fill(visited[i], Boolean.FALSE);
                Arrays.fill(dMap[i], '0');
            }
        }

        void fillDrawing(char[] chars, int row){
            for(int i = 0; i < N; i++){
                dMap[row][i] = chars[i];
            }
        }

        void resetDrawing(){
            for(int i = 0; i < N; i++){
                Arrays.fill(visited[i], Boolean.FALSE);
            }
        }

        void DFS(int sx, int sy, boolean cb){
            visited[sx][sy] = true;
            char cur = dMap[sx][sy];
            for(int[] v : mv){
                if(sx + v[0] < N && sy + v[1] < N && sx + v[0] > -1 && sy + v[1] > -1){
                    if(!visited[sx + v[0]][sy + v[1]]){
                        if(dMap[sx + v[0]][sy + v[1]] == cur ){ // 정상인
                            DFS(sx + v[0], sy + v[1] , cb);
                        } else if (cb
                                && (dMap[sx + v[0]][sy+v[1]] == 'R' || dMap[sx + v[0]][sy+v[1]] == 'G')
                                && ( cur == 'R' || cur == 'G' ) ){ //색약
                            DFS(sx + v[0], sy + v[1], cb);
                        }
                    }
                }
            }
        }
    }
}