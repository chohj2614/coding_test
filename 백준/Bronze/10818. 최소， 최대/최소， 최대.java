import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int min = 1000000;
        int max = -1000000;
        for(int i = 0; i < N; i++){
            int cur = Integer.parseInt(nums[i]);
            if(cur < min){min = cur;}
            if(cur > max){max = cur;}
        }
        System.out.println(min + " " + max);
    }
}