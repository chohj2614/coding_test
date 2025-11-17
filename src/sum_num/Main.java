package sum_num;//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String temp = br.readLine();
        String[] num = temp.toCharArray();
        for(int i = 0; i < len; i++){
            int cur = Integer.parseInt(num.charAt(i));
        }

        System.out.print(msg.length);
    }
}