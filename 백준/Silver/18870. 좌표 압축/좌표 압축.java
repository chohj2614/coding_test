import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        String[] inputs = br.readLine().split(" ");
//        Set<Integer> set = new TreeSet<>(); // 중복 제거는 map에 넣을 때
        for(int n = 0 ; n < N; n++){
            int cur = Integer.parseInt(inputs[n]);
            nums[n] = cur;
//            set.add(cur);
        }
        int[] sorted = Arrays.copyOf(nums,nums.length);
        Arrays.sort(sorted);
        Map<Integer,Integer> map = new HashMap<>();
        int idx = 0;
        for(int x : sorted){
            if(!map.containsKey(x)){
                map.put(x,idx);
                idx++;
            }
        }
        
        for(int x: nums){
            sb.append(map.get(x) + " ");
        }
        System.out.println(sb.toString());
    }
}