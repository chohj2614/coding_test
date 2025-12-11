import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        //시간 초과
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
//        int[] nums = new int[n];
        Set<Integer> nSet = new HashSet<>();
        for(int i = 0; i < n ; i++){
//            nums[i] = Integer.parseInt(inputs[i]);
            nSet.add(Integer.parseInt(inputs[i]));
        }
        int m = Integer.parseInt(br.readLine());
        int[] targets = new int[m];
        inputs = br.readLine().split(" ");
        for(int i= 0; i < m; i++){
            targets[i] = Integer.parseInt(inputs[i]);
        }
        for(int i = 0; i < m; i++){
            if(nSet.contains(targets[i])){
                System.out.println("1");
            } else{
                System.out.println("0");
            }
//            boolean found = false;
//            for(int j = 0; j<n; j++){
//                if(targets[i] == nums[j]){
//                    System.out.println("1");
//                    found = true;
//                    break;
//                }
//            }
//            if(!found){
//                System.out.println("0");
//            }
        }
    }
}