import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        // 3) 이진 탐색
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[n];
        for(int i = 0; i < n ; i++){
            nums[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(nums);
        int m = Integer.parseInt(br.readLine());
        int[] targets = new int[m];
        inputs = br.readLine().split(" ");
        for(int i= 0; i < m; i++){
            targets[i] = Integer.parseInt(inputs[i]);
        }

        for(int i = 0; i < m; i++){
            if(Arrays.binarySearch(nums, targets[i]) < 0){
                System.out.println("0");
            } else {
                System.out.println("1");
            }
        }
    }
}