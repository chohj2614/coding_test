package 문자열_반복;//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().split(" ")[0]);

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            int toRepeat = Integer.parseInt(input[0]);
            String msg = input[1];
            String temp = "";
            for(int j = 0; j < msg.length(); j++){
                char c = msg.charAt(j);
                for(int k =0; k < toRepeat; k++){
                    temp = temp + c;
                }
            }
            System.out.println(temp);
        }

    }
}