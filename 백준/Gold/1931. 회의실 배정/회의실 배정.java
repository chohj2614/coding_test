import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N][2];
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            schedule[i][0] = Integer.parseInt(input[0]);
            schedule[i][1] = Integer.parseInt(input[1]);
        }
//        Arrays.sort(schedule, Comparator.comparing(arr -> arr[1]));
        // 종료 시간을 기준으로 오름차순 정렬

//        Arrays.sort(schedule, (a, b) -> { // a와 b를 비교할 때,
//            if (a[1] == b[1]) return a[0] - b[0]; // 두번째 입력값이 같다면, 첫번째를 비교
//            return a[1] - b[1]; // 다르다면 두번째 index 비교
//        });
        
        Arrays.sort(schedule, Comparator.comparing((int[] a)-> a[1]) //두번째 값 비교
                                         .thenComparing(a -> a[0]) // 같다면 첫번째 값 비교
        );

//        System.out.println(Arrays.deepToString(schedule));

        int count = 0;
        int endTime = 0;
        for(int i = 0; i < N; i++){
            if(schedule[i][0] >= endTime){
                count++;
                endTime =schedule[i][1];
            }
        }
        System.out.println(count);
    }
}