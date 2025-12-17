import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int[] nums = new int[N];
        inputs = br.readLine().split(" ");

        nums[0] = Integer.parseInt(inputs[0]);
        for(int i = 1; i < N; i++){
//            nums[i] = Integer.parseInt(inputs[i]);
            nums[i] = nums[i-1] + Integer.parseInt(inputs[i]);
        }

        for(int m = 0; m < M; m++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int sum = nums[end - 1];
            if(start == 2){
                sum -= nums[0];
            } else if (start == 1){
                sum = nums[end-1];
            } else{
                sum -= nums[start-2];
            }
            sb.append(sum).append("\n");
//            int sum = 0;
//            // 배열 복사는 시간이 길다. -> 시간 초과
//            for(int x : Arrays.copyOfRange(nums,start - 1, end)){
//                sum += x;
//            }
//            sb.append(sum + "\n");
        }
        System.out.print(sb.toString());
    }
}