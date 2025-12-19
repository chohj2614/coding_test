package coding_prob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class cur_prob {
    public static int[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // NxN grid
        grid = new int[N][N];
        int fill = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = fill;
                fill++;
            }
        }
        System.out.println(Arrays.deepToString(grid));
        int R = Integer.parseInt(input[1]); // 목표 row
        int C = Integer.parseInt(input[2]); // 목표 col

        int result = search(R,C);

        System.out.println(result);
    }

    public static int search(int r, int c, int N){
        int count = 0;
        int numb_sections = Math.getExponent(N); // 몇개의 2x2가 있는지 확인
        int row_left = r/2; // 목표값 왼쪽에 2x2가 몇개 있나
        int col_up = c/2; // 목표값 위쪽에 2x2가 몇개 있나
        // 현재 2x2에서 몇번째에 있나

        return count;
    }
}