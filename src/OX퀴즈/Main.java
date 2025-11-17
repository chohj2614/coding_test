package OX퀴즈;//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String str = br.readLine();
            int prev = 0;
            int sum = 0;
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == 'O'){
                    prev++;
                    sum += prev;
                }  else if (str.charAt(j) == 'X'){
                    prev = 0;
                }
            }
            System.out.println(sum);
        }
    }
}