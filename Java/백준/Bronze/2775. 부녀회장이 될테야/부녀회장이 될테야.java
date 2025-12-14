import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int k = Integer.parseInt(br.readLine());  //층수
            int n = Integer.parseInt(br.readLine());  //호수
            int[] prev_lev = new int[n]; //1~n호수까지

            for(int i = 0; i < n; i++){ //0층 n개의 호수
                prev_lev[i] = i + 1;
            }

            for(int i = 1; i <= k; i++){ //1 ~ k 층
                int[] cur_lev = new int[n];
                for(int j = 0; j < n; j++){
                    cur_lev[j] = getSum(prev_lev, j);
                }
                prev_lev = cur_lev;
            }
            System.out.println(prev_lev[n-1]);
        }
    }

    // 현재 층에 이전 층 0 ~ n-1 호수 합 구하기
    static int getSum(int[] prev, int j){
        int sum = 0;
        for(int i = 0; i <= j; i++){
            sum += prev[i];
        }
        return sum;
    }
}

/*
 1 3 6 10 15 21 28
 1 2 3  4  5 6  7
 */