import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] newLine = br.readLine().split(" ");
        int N = Integer.parseInt(newLine[0]);
        int X = Integer.parseInt(newLine[1]);
        newLine = br.readLine().split(" ");
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(newLine[i]);
        }
        for(int x: nums){
            if(x < X){
                System.out.print(x + " ");
            }
        }

    }
}