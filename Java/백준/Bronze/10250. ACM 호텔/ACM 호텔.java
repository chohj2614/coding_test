import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String[] inputs = br.readLine().split(" ");
            int H = Integer.parseInt(inputs[0]);
            int W = Integer.parseInt(inputs[1]);
            int N = Integer.parseInt(inputs[2]);

            int num = N/H;
            int floor = (N-1) % H + 1;
            int room = (N-1) / H + 1;
            System.out.println(floor * 100 + room);
        }
    }
}