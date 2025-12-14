
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 9;
        int max_v = 0;
        int max_i = 0;
        for(int i =0; i < N; i++){
            int cur = Integer.parseInt(br.readLine());
            if(cur > max_v){
                max_v = cur;
                max_i = i+1;
            }
        }
        System.out.println(max_v + "\n" + max_i);
    }
}
