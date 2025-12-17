import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t= 0; t < T; t++){
            // remove 때문에 시간 초과
//        Queue<Integer> pqMin = new PriorityQueue<>();
//        Queue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
            TreeMap<Integer,Integer> map = new TreeMap<>(); // 정렬되는 TreeMap 사용
            // Map 사용시 .lastKey, .firstKey 사용 불가.
            // 왼쪽도 TreeMap으로 지정
            int K = Integer.parseInt(br.readLine());
            String[] inputs = new String[2];

            for(int k = 0; k < K; k++){ // 명령어 iterate
                inputs = br.readLine().split(" ");
                int num = Integer.parseInt(inputs[1]);
                String operation = inputs[0];
                if(operation.equals("I")){
                    map.put(num, map.getOrDefault(num,0) + 1);
//                    pqMax.offer(num);
//                    pqMin.offer(num);
                } else { // operation = "D"
//                    if(pqMax.isEmpty()){
                    if(map.isEmpty()){ // 비어있는 큐
                        continue;
                    }
                    if(num == 1){ // remove max
//                        int max = pqMax.poll();
//                        pqMin.remove(max);
                        if(map.get(map.lastKey()) > 1){ // 중복 있을 시
                            map.put(map.lastKey(), map.get(map.lastKey()) - 1);
                        } else { //중복 없을 시
                            map.remove(map.lastKey()); // 최댓값 제거
                        }
                    } else { // num == -1. remove min
//                        int min = pqMin.poll();
//                        pqMax.remove(min);
                        if(map.get(map.firstKey()) > 1){ // 중복 있을 시
                            map.put(map.firstKey(), map.get(map.firstKey()) - 1);
                        } else { // 중복 없음
                            map.remove(map.firstKey()); //최솟값 제거
                        }
                    }
                }
            }
//            if(pqMin.isEmpty()){
            if(map.isEmpty()){
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey() + " " + map.firstKey() + "\n");
//                sb.append(pqMax.poll() + " " + pqMin.poll() + "\n");
            }
        }

        System.out.print(sb.toString());
    }
}