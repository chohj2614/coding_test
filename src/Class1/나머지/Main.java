package 나머지;//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < t; i++){
            int cur = Integer.parseInt(br.readLine());
            cur = cur % 42;
            set.add(cur);
        }
        System.out.println(set.size());
    }
}