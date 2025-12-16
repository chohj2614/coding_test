import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
            // 시간 초과 -> StringBuilder 사용
        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < M; i++){
            String[] input = br.readLine().split(" ");
            String instruction = input[0];
            int num = 0;
            if(input.length == 2){
                num = Integer.parseInt(input[1]);
            }
            if(instruction.equals("add")){
                set.add(num);
            } else if (instruction.equals("remove")){
                set.remove(num);
            }else if (instruction.equals("check")){
                if(set.contains(num)) sb.append("1\n");
                else sb.append("0\n");
            }else if (instruction.equals("toggle")){
                if(set.contains(num)) set.remove(num);
                else set.add(num);
            }else if (instruction.equals("all")){
                IntStream.rangeClosed(1,20).forEach(set::add); // 1~20을 inclusive로 set에 add
            }else if (instruction.equals("empty")){
                set.clear();
            }
        }
        System.out.println(sb.toString());
    }
}