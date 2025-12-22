import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        String[] inputs = new String[2];
        int[][] nums = new int[N][2];
        for(int i = 0 ; i < N; i++){
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            nums[i] = new int[]{x,y};
        }
//        System.out.println(Arrays.deepToString(nums));
        Arrays.sort(nums,(o1,o2) -> o1[0] - o2[0]);
//        System.out.println(Arrays.deepToString(nums));
//        for(int i =0 ; i < N -1; i++){ // 문제점 : (1,10), (2,3), (4,5) -> 10으로 인해 뒤에가 모두 깨짐
//            if(nums[i][1] >= nums[i+1][0]){
//                nums[i+1][0] = nums[i][1];
//            }
//        }

        for (int i = 1; i < N ; i++) {
            nums[i][0] = Math.max(nums[i][0],nums[i-1][1]);
            nums[i][1] = Math.max(nums[i][1],nums[i-1][1]);
        }
//        System.out.println(Arrays.deepToString(nums));
        int total = 0;
        for(int[] coord : nums){
            total += coord[1] - coord[0];
        }
        System.out.println(total);
    }
}