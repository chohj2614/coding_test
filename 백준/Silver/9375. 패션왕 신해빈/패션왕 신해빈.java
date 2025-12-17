import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map= new HashMap<>();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            map.clear();
            int N = Integer.parseInt(br.readLine()); // 의상 수
            String[] input = new String[2];
            for(int i = 0; i < N; i++){ // 종류의 의상별로 increment
                input = br.readLine().split(" ");
                map.put(input[1],map.getOrDefault(input[1],0) + 1);
            }
            int comb = 1;
            for(String k: map.keySet()){
                comb *= 1 + map.get(k);

            }
            comb -= 1;
            sb.append(comb + "\n");
        }

        System.out.println(sb.toString());
    }
}