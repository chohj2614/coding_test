import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[inputs.length];
        for(int i = 0; i < inputs.length; i++){
            nums[i] = Integer.parseInt(inputs[i]);
        }
        int sum= 0;
        for(int x : nums){
            sum += x*x;
        }
        System.out.println(sum%10);
    }
}