import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 의견수 저장
        int N = Integer.parseInt(br.readLine());
//        List<Integer> list = new ArrayList<>();
        int[] arr = new int[N];
        // 의견들 저장
        for(int i = 0; i < N; i++){
//            list.add(Integer.parseInt(br.readLine()));
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 의견들 정렬
//        Collections.sort(list);
        Arrays.sort(arr);

        // 극단값 자르기
        int perc = (int)Math.round(N * 0.15);

//        for(int i = 0; i< perc; i++){
//            list.remove(0);
//            list.remove(list.size() - 1 );
//        }
        int ans = 0;
//        for(int x : list){
//            ans += x;
//        }
        for(int i = perc; i < N - perc; i++){
            ans += arr[i];
        }
//        ans = (int)Math.round(ans/(double)list.size());
        ans = (int)Math.round(ans/(double)(arr.length - perc*2));
        System.out.println(ans);
    }
}