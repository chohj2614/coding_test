import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String[] NandM = br.readLine().split(" ");
            int N = Integer.parseInt(NandM[0]);
            int M = Integer.parseInt(NandM[1]);

            // 큐 생성
            Queue<int[]> queue = new LinkedList<>();
            String[] inputs = br.readLine().split(" ");
            // 문서 & 들어온 순서 같이 저장
            for(int j = 0; j < N; j++){
                queue.add(new int[] {j,Integer.parseInt(inputs[j])});
            }
            int count = 0; // 출력한 개수

            while(!queue.isEmpty()){
                if(checkPrint(queue , queue.peek()[1])){ //출력
                    if(queue.peek()[0] == M){ // 목표 idx 가 출력되는지 확인
                        count++;
                        break;
                    }
                    queue.poll(); // 큐에서 제외
                    count++; //출력 수 ++
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