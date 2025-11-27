import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String[] NandM = br.readLine().split(" ");
            int N = Integer.parseInt(NandM[0]);
            int M = Integer.parseInt(NandM[1]);
            Queue<int[]> queue = new LinkedList<>();
            String[] inputs = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                queue.add(new int[] {j,Integer.parseInt(inputs[j])});
            }
            int count = 0; // 출력한 개수
            while(!queue.isEmpty()){
                if(checkPrint(queue , queue.peek()[1])){ //출력
                    if(queue.peek()[0] == M){
                        count++;
                        break;
                    }
                    queue.poll();
                    count++;
                } else { //맨뒤로
                    queue.add(queue.poll());
                }
            }
            System.out.println(count);
        }
    }

    // 입력값보다 높은 숫자가 있으면 false -> queue에 넣기
    static boolean checkPrint(Queue<int[]> queue, int cur){
        for(int[] i : queue){
            if (i[1] > cur){
                return false;
            }
        }
        return true;
    }
}