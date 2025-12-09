import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Apt apart = new Apt(N);
        for(int i = 0 ; i < N; i++){
            int[] nums = new int[N];
            char[] cs = br.readLine().toCharArray();
            for(int j = 0; j < N; j++ ){
                nums[j] = Integer.parseInt(Character.toString(cs[j]));
            }
            apart.drawMap(nums, i);
        }


        System.out.println();
    }

    public static class Apt{
        private int N;
        private LinkedList<Integer> rec;
        private int count;
        private int[][] aptMap;
        private boolean[][] visited;

        Apt(int n){
            N = n;
            aptMap = new int[N][N];
            visited = new boolean[N][N];
        }

        void drawMap(int[] nums, int row){
            for(int i = 0; i < N; i++){
                aptMap[row][i] = nums[i];
            }
        }

        void DFS(int sx, int sy){
            visited[sx][sy] = true;
            if(aptMap[sx][sy] == 1){
                count++;
            }

        }
    }
}