import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        //평균
        System.out.println((int)Math.round((double)sum/(double)N));
        Arrays.sort(arr);

        //중앙값
        System.out.println(arr[(N - 1)/2]);

        //최빈값

        //값 별로 count를 mapping
        Map<Integer,Integer> freq = new HashMap<>();
        for(int x: arr){
            freq.put(x, freq.getOrDefault(x,0) + 1);
        }

        int mode = arr[0];
        int max_count = freq.get(arr[0]);
        // 최근에 찾은 숫자 넣기
        Queue<Integer> queue = new LinkedList<>();
        for(int x: arr){
            int count = freq.get(x);
            if(queue.contains(x)){ //중복값 스킵
                continue;
            }
            if(count >= max_count){
                if(count == max_count){ //동일한 빈도수 객체
                    queue.offer(x); //같은 빈도수 넣기
                } else{
                    queue.clear();
                    mode = x;
                    max_count = count;
                    queue.offer(x);
                }
            }
        }
        if(queue.size()>1){ //두번째로 작은값 사용
            queue.poll(); //첫번째로 작은값 추출
            mode = queue.poll();
        }
        // 최빈값
        System.out.println(mode);
        // 범위
        System.out.println((arr[N-1] - arr[0]));
    }
}