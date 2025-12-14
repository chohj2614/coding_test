import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
//        dp[6] = 3; // dp[1] + dp[5]  = 1 + 2 = 3
//        dp[7] = 4; // dp[2] + dp[6]  = 1 + 3 = 4
//        dp[8] = 5; // dp[3] + dp[7]  = 1 + 4 = 5
//        dp[9] = 7; // dp[4] + dp[8]  = 2 + 5 = 7
//        dp[10] = 9; // dp[5] + dp[9] = 2 + 7 = 9
//        dp[11] = 12; //dp[6] + dp[10] = 3 + 9 = 12
        for (int i = 6; i < dp.length; i++) {
            dp[i] = dp[i - 5] + dp[i - 1];
        }
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}