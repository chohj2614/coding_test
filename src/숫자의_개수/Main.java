package 숫자의_개수;//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int temp = a * b * c;
        String str = String.valueOf(temp);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int cur = str.charAt(i) - '0';
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur,1);
            }

        }
        for(int i =0; i < 10; i++){
            if(map.containsKey(i)) {
                System.out.println(map.get(i));
            }else{
                System.out.println(0);
            }
        }
    }
}