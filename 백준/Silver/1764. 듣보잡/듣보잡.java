import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 듣도 못한 사람 수 N
        int M = Integer.parseInt(input[1]); // 보도 못한 사람 수 M
        // 중복 없음
        Set<String> setN = new HashSet<>();
        Set<String> setM = new HashSet<>();
        for(int i =0 ; i < N; i++){
            setN.add(br.readLine());
        }
        for(int i =0; i < M; i++){
            setM.add(br.readLine());
        }
        List<String> duplicates = new ArrayList<>();
        for(String s : setN){
            if(setM.contains(s)){
                duplicates.add(s);
            }
        }
        Collections.sort(duplicates);
        StringBuilder sb= new StringBuilder();
        for(String s: duplicates){
            sb.append(s + "\n");
        }
        System.out.println(duplicates.size());
        System.out.println(sb.toString());
    }
}