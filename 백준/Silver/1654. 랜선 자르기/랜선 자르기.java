import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int K = Integer.parseInt(inputs[0]); // 랜선의 개수 K
        int N = Integer.parseInt(inputs[1]); // 필요한 랜선의 수 N
        long[] lengths = new long[K];
        for(int i = 0; i < K; i++){
            lengths[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(lengths);
        long result = 0;
        long left = 1;
        long right = lengths[lengths.length-1];
        while(left <= right){
            long mid = (left + right)/ 2;
            if(check(mid, lengths, N)) {// 더 긴 길이 탐색
                result = mid;
                left = mid + 1;
            } else {// 더 짧은 길이 탐색
                right = mid - 1;
            }
        }
//        for(long i = lengths[lengths.length -1]; i > 0; i--){ // 시간초과
//            if(check(i,lengths, N)){
//                result = i;
//                break;
//            }
//        }
        System.out.println(result);
    }

    static boolean check(long len, long[] arr,int N){
        int cnt = 0;
        for(long x : arr){
            cnt += x/len;
        }
        return cnt >= N;
    }

}