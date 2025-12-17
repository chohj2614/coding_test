import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        long B = Integer.parseInt(inputs[2]); // 인벤토리에 있는 블록 수

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++){
            inputs = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int min_time = Integer.MAX_VALUE;
        int max_height = 0;
        for(int i = 0; i <= 256; i++){
            int[] temp = count(N,M,map,i,B);
            if(temp[0] == 1 && temp[1] <= min_time){ //시간이 같은 경우 높은 높이 선택
                max_height = i;
                min_time = temp[1];
            }
        }
        System.out.println(min_time + " " + max_height);
    }

    public static int[] count(int N, int M, int[][] map, int aim, long B){
        int count = 0;
        for(int[] row : map){
            for(int i : row){
                if(i < aim){
                    count += aim - i;
                    B -= aim-i;
                }else if (i > aim){
                    count += 2*(i - aim);
                    B += i-aim;
                }
            }
        }
        if(B < 0){// 전체 블록 조정 후 확인
            return new int[]{0,count};
        }
        return new int[]{1, count};
    }

}