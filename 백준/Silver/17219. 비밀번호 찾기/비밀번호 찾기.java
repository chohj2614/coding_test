import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        Map<String,String> emailToPass = new HashMap<>();

        for(int i = 0; i < N; i++){
            inputs = br.readLine().split(" ");
            emailToPass.put(inputs[0],inputs[1]);
        }
        String input = "";
        for(int i = 0; i < M; i++){
            input = br.readLine();
            sb.append(emailToPass.get(input) + "\n");
        }
        System.out.println(sb.toString());
    }
}