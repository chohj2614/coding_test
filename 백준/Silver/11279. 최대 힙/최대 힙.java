import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 우선순위 q로 최대힙 구현
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        int cur = 0;
        for(int i =0 ; i< N; i++){
            cur = Integer.parseInt(br.readLine());
            if(cur == 0){
                if (pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            } else {
                pq.offer(cur);
            }
        }
    }
}