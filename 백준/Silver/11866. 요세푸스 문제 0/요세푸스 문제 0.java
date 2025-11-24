import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //N,K 받기
        String[] newLine = br.readLine().split(" ");
        int N = Integer.parseInt(newLine[0]);
        int K = Integer.parseInt(newLine[1]);

        //N까지의 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        for(int i =1; i < N+1; i++){
            queue.offer(i);
        }
        sb.append("<");
        while(!queue.isEmpty()){
            for(int i = 0; i < K - 1; i++){
                int temp = queue.poll();
                queue.offer(temp);
            }
            sb.append(queue.poll());
            if(queue.isEmpty()){
                sb.append(">");
            } else{
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }
}