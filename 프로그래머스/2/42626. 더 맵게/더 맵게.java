import java.util.PriorityQueue;
import java.util.Queue;
class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int x : scoville){
            pq.offer(x);
        }
        int least = pq.peek();
        int answer = 0;
        while(pq.size()>= 2 && least < K){
            pq.offer(pq.poll() + pq.poll()*2);
            least = pq.peek();
            answer++;
        }
        if(pq.peek() == null || pq.peek() < K){
            return -1;
        }
        return answer;
    }
}