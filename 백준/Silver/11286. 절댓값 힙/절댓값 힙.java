import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int temp1 = Math.abs(o1);
                int temp2 = Math.abs(o2);
                if(temp1 == temp2){
                    return o1 - o2;
                }
                return temp1 - temp2;
            }
        });

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            if(cur == 0){
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            } else {
                pq.offer(cur);
            }
        }
//        System.out.println();
    }
}