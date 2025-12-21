import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 수 읽기
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(); // 결과값 저장

        testLoop:
        for (int t = 0; t < T; t++) {
            // 명령들 읽어오기
            String operation = br.readLine();
            // 배열 길이 읽어오기
            int N = Integer.parseInt(br.readLine());
            // [ 또는 ] 또는 , 없애고 빈칸 기준으로 split
            String[] arr = br.readLine().replaceAll("[\\[\\]]", "").split(",\\s*");
            Deque<Integer> deque1 = new ArrayDeque<>(); // 주어진 원본 배열
            Deque<Integer> deque2 = new ArrayDeque<>(); // 뒤집은 배열

            for (int i = 0; i < N; i++) {
                deque1.offerLast(Integer.parseInt(arr[i])); // 읽는대로 뒤에 추가
                deque2.offerFirst(Integer.parseInt(arr[i])); // 읽는대로 앞에 추가
            }

            boolean first = true; // 배열 순서 표시
            for (char c : operation.toCharArray()) { // 명령문 실행
                if (c == 'R') { // 뒤집기
                    first = !first;
                } else if (c == 'D') { // 맨 앞 수 빼기
                    if (deque1.isEmpty()) { // 배열이 비었을 때
                        sb.append("error\n");
                        continue testLoop; // 현재 테스트 케이스 스킵
                    }
                    if (first) { // 처음 상태
                        deque1.pollFirst();
                        deque2.pollLast();
                    } else { // 뒤집은 상태
                        deque1.pollLast();
                        deque2.pollFirst();
                    }
                }
            }
            sb.append("[");
            if (first) {
                for(int x : deque1){
                    sb.append(x+",");
                }
//                sb.append(deque1.toString());
            } else {
                for(int x : deque2){
                    sb.append(x+",");
                }
//                sb.append(deque2.toString());
            }
            // 모든 배열을 출려해서 비었을 때, ","는 없기 때문에 마지막 char 지우면 ]만 남음
            /* 반례 : 
            입력: 1
                 D
                 1
                 [10]
            출력: []
            */
            if(!deque1.isEmpty()) sb.deleteCharAt(sb.length() -1); // 마지막 ',' 지우기
            sb.append("]\n");
        }
        System.out.println(sb.toString());
    }
}
