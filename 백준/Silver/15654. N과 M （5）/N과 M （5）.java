import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N,M;
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    static int[] given;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        given = new int[N];
        input = br.readLine().split(" ");
        given = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(given);
        StringBuilder sb= new StringBuilder();

        comb();

        for(List<Integer> pair: list){
            for(int x : pair){
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    public static void comb() {
        if(!temp.isEmpty() && temp.size() == M) {
            list.add(new ArrayList<>(temp)); // temp 내용과 동일한 새로운 객체 추가
            return;
        }
        for (int i = 0; i < N; i++) {
            if(temp.contains(given[i])) continue; // 중복 방지
            temp.add(given[i]); // 현재 index 수열에 추가
            comb();
            temp.remove(temp.size()-1); // 마지막 수는 빼기
        }
    }
}
