import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long r = 31;
        long M = 1234567891;
        long ans = 0;
        long pow = 1;
        for(int i = 0; i < L; i++){
            int cur = str.charAt(i) - 'a' + 1;
            ans = (ans + cur*pow) % M;
            pow = (pow * r) % M;
        }
        System.out.println(ans);
    }
}