import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] duration = new int[N];
        for(int i =0 ; i < N; i++) {
            duration[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(duration);
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += duration[i] * (N - i);
        }
        System.out.println(sum);
    }
}