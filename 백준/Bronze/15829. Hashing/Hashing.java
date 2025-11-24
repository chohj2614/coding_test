import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] carr = str.toCharArray();
        int r = 31;
        int M = 1234567891;
        int ans = 0;
        for(int i = 0; i < L; i++){
            int cur = carr[i] - 'a' + 1;
            ans += Math.pow(r,i) * cur;
        }
        ans = Math.floorMod(ans,M);
        System.out.println(ans);
    }
}