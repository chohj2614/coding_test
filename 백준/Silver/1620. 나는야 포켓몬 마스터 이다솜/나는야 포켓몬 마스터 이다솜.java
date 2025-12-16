import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Map<Integer,String> intMap = new HashMap<>();
        Map<String, Integer> strMap = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String cur = br.readLine();
            intMap.put(i,cur);
            strMap.put(cur,i);
        }
        for(int i = 0; i < M; i++){
            String cur = br.readLine();
            // containsKey -> 복잡도 O(1)
            // containsValue -> 복잡도 O(N) => 시간 초과 원인
            if(strMap.containsKey(cur)) sb.append(strMap.get(cur).toString() + "\n");
            else{
                int idx = Integer.parseInt(cur);
                sb.append(intMap.get(idx) + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}