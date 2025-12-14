import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[50000 + 1];
        dp[1] = 1;
        dp[2] = 2; // 1 1
        dp[3] = 3; // 1 1 1
        dp[4] = 1; // 2
        dp[5] = 2; // 2 1
        for(int i = 3; i <= N; i++){
            dp[i] = i;
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}