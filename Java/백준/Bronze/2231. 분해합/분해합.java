import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N_str = br.readLine();
        int N = Integer.parseInt(N_str);
        int N_digits = N_str.length();
        int min = N - 9*N_digits;
        int ans = 0;
        for(int i = min; i < N; i++){
            if(i + sumChar(i) == N){
                ans = i;
                break;
            }
        }
        System.out.println(ans);

    }
    static int sumChar(int numb){
        int sum = 0;
        String temp = String.valueOf(numb);
        for(char C: temp.toCharArray()){
            int cur = C - '0';
            sum += cur;
        }
        return sum;
    }
}