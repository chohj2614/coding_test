import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        testLoop:
        for (int t = 0; t < T; t++) {
            String operation = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().replaceAll("[\\[\\]]", "").split(",\\s*");
            Deque<Integer> deque1 = new ArrayDeque<>();
            Deque<Integer> deque2 = new ArrayDeque<>();
            for(int i = 0; i < N; i++){
                deque1.offerFirst(Integer.parseInt(arr[i]));
                deque2.offerLast(Integer.parseInt(arr[i]));
            }
//            System.out.println(deque1);
//            System.out.println(deque2);

//            List<Integer> result = new ArrayList<>();
            boolean first = true;
            for(char c : operation.toCharArray()){
                if(c == 'R'){
                    first = !first;
                }else if(c == 'D'){
                    if(deque1.isEmpty()){
                        sb.append("error\n");
                        continue testLoop;
                    }
                    if(first){ // 처음 상태
                        deque1.pollFirst();
                        deque2.pollLast();
                    } else { // 뒤집은 상태
                        deque1.pollLast();
                        deque2.pollFirst();
                    }
                }
            }
            sb.append("[");
            if(first){
                for(int x : deque1){
                    System.out.println(x);
                    sb.append(x+ ", ");
                }
            } else {
                for(int x : deque2){
                    System.out.println(x);
                    sb.append(x+ ", ");
                }
            }

            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-2);
            sb.append("]\n");
            break;
        }

        System.out.println(sb.toString());
    }
}