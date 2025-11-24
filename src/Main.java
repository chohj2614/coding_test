import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[] cur_lev = IntStream.range(1,n+1).toArray();
            int[] prev_lev = new int[n];

            for(int i = 1; i <= k; i++){ //0 ~ k 층
                prev_lev = cur_lev;
                for(int j = 0; j < n; j++){
                    cur_lev[j] = getSum(prev_lev, j);
                }
            }
            System.out.println(cur_lev[n-1]);
        }
    }
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