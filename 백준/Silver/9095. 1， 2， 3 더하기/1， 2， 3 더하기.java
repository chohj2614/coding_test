import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2; // 1 + 1, 2
        dp[3] = 4; // 1 + 1 + 1, 1 + 2, 2 + 1, 3
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            for(int i = 4; i <= N; i++){
                if(dp[i] == 0){
                    dp[i] = dp[i - 1] + dp[i-2] + dp[i-3];
                }
            }
            System.out.println(dp[N]);
        }
    }
}