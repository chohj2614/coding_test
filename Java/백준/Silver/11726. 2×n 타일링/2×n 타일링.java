import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[1000 + 1];
        int N = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
//        dp[4] = 5;
//        dp[5] = 8;
//        dp[6] = dp[4]+dp[5];
        for(int i = 4; i < dp.length; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007; //long의 오버플로우 방지
        }
        System.out.println(dp[N]);
    }
}