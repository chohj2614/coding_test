import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[1000 + 1];
        int N = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
//        dp[4] = 11;
//        dp[5] = 21; // = dp[4] + dp[3]*2
        for(int i = 4; i < N + 1; i++){ //N+1 으로 시간단축
            dp[i] = (dp[i-2] * 2  + dp[i-1]) % 10007; //long의 오버플로우 방지
        }
        System.out.println(dp[N]);
    }
}