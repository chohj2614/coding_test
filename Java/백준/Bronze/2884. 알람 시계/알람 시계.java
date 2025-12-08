import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int H = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        M -= 45;
        if(M < 0){
            H -= 1;
            M += 60;
        }
        if(H < 0){
            H = 23;
        }

        System.out.println(H + " "+ M);
    }
}