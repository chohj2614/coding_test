import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        int[] options = new int[N];
        for(int i = 0; i < N; i++){
            options[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int o_ind = N-1;
        while(K != 0){
            int cur = K / options[o_ind];
            K -= options[o_ind] * cur;
            o_ind--;
            count+= cur;
        }

        System.out.println(count);
    }
}