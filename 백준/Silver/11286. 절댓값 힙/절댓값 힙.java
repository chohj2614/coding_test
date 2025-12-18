import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 1. 람다 형식 --> 2 보다 성능이 좋음
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a,b) -> {
                int absA = Math.abs(a);
                int absB = Math.abs(b);
                if(absA!= absB) return absA - absB; // 다를 경우 절대값 비교
                return a-b; //같은 절대값 -> 자연수로 비교
            });
        // 2. Comparator.comparingInt 형식
//        PriorityQueue<Integer> pq =
//                new PriorityQueue<>(
//                        Comparator.comparing((Integer x) -> Math.abs(x))
//                                .thenComparingInt(x->x)
//                );
        for(int i = 0; i < N; i++){
            int cur = Integer.parseInt(br.readLine());
            if(cur == 0){
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            } else {
                pq.offer(cur);
            }
        }
    }
}
