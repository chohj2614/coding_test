import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp = new int[41][2]; // dp[n][0] = zero count, dp[n][1] = one count
        // given 40보다 작거나 같은 자연수 -> [41]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i = 2;i <= 40; i++){
            dp[i][0] =  dp[i-1][0] + dp[i-2][0];
            dp[i][1] =  dp[i-1][1] + dp[i-2][1];
        }
        for(int t = 0; t < T; t++){
            int cur = Integer.parseInt(br.readLine());
            System.out.println(dp[cur][0] + " " + dp[cur][1]);
        }
    }

}