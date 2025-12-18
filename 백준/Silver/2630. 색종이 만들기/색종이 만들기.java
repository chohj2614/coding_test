import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] colors = new int[2]; // 0 : white , 1 : blue
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] inputs = br.readLine().split(" ");
            for(int x = 0; x < N; x++){
                map[i][x] = Integer.parseInt(inputs[x]);
            }
        }
        cut(0,N, 0, N, map);

        System.out.println(colors[0]);
        System.out.println(colors[1]);
    }
    public static void cut(int lx, int rx, int ly, int ry, int[][] map){
        if(checkAll(lx,rx,ly,ry,map)){
            colors[map[lx][ly]]++;
        } else {
            int mx = (lx + rx) / 2;
            int my = (ly + ry) / 2;
            // 위 왼
            cut(lx, mx, ly, my, map);
            // 위 오
            cut(lx, mx, my, ry, map);
            // 아 윈
            cut(mx, rx, ly, my, map);
            // 아 오
            cut(mx, rx, my, ry, map);
        }
    }
    public static boolean checkAll(int lx, int rx, int ly, int ry, int[][] map){
        int color = map[lx][ly];
        for(int x = lx; x < rx; x++){
            for(int y = ly; y < ry; y++){
                if(map[x][y] != color){
                    return false;
                }
            }
        }
        return true;
    }

}