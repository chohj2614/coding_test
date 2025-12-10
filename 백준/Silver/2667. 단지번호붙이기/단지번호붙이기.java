import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
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
        LinkedList<Integer> countList = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!apart.visited[i][j] && apart.aptMap[i][j] == 1){
                    apart.count = 0;
                    apart.DFS(i, j);
                    countList.add(apart.count);
                }
            }
        }

        Collections.sort(countList);
        System.out.println(countList.size());
        for(int x : countList){
            System.out.println(x);
        }
    }

    public static class Apt{
        private int N;
        private int count;
        private LinkedList<Integer> rec;
        private int[][] aptMap;
        private boolean[][] visited;
        private int[][] mv = {{1,0}, {-1, 0}, {0,1}, {0,-1}};

        Apt(int n){
            N = n;
            aptMap = new int[N][N];
            visited = new boolean[N][N];
            for(int i =0 ; i < N; i++){
                Arrays.fill(aptMap[0], 0);
                Arrays.fill(visited[0], Boolean.FALSE);
            }
        }

        void drawMap(int[] nums, int row){
            for(int i = 0; i < N; i++){
                aptMap[row][i] = nums[i];
            }
        }

        void DFS(int sx, int sy){
            visited[sx][sy] = true;
            count++;
            for(int[] v: mv){
                if(sx + v[0] < N && sx + v[0] > -1 && sy + v[1] < N && sy + v[1] > -1){
                    if(!visited[sx + v[0]][sy + v[1]]){
                        if(aptMap[sx + v[0]][sy + v[1]] == 1){
                            DFS(sx + v[0], sy + v[1]);
                        }
                    }
                }
            }
        }


    }
}