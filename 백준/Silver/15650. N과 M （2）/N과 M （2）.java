import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N,M;
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        StringBuilder sb= new StringBuilder();
        comb(1);
        for(List<Integer> pair: list){
            for(int x : pair){
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }
//        for(int i = 1; i < N; i++){
//            for(int j = i+1; j < M ; j++){
//                for(int j = i+1; j < M ; j++){
//                    sb.append{i + j+k};
//                }
//            }
//        }
//
        System.out.print(sb.toString());
    }

    public static void comb(int start) {
        if(!temp.isEmpty() && temp.size() == M) {
            list.add(new ArrayList<>(temp)); // temp 내용과 동일한 새로운 객체 추가
            return;
        }
        for (int i = start; i <= N; i++) {
            temp.add(i); // 현재 수열에 추가
            comb(i + 1); // 다음 자리부터 다시 수열 추가
            temp.remove(temp.size()-1); // 마지막 수는 빼기
        }
    }
}
