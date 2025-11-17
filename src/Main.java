//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    //입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

    //입력값을 배열로 변환
        String[] arr = input.split(" "); //공백을 기준으로 input이라는 string을 자르겠다. 반환값은 배열

    //Print test
//        System.out.println("Hello and welcome!" + input);
//        System.out.println(arr[0] + arr[1]); //Type이 현재는 숫자가 아니기에 에러.

    //문자를 숫자로 변환
        int first = Integer.parseInt(arr[0]); //문자에서 숫자로 변환
        int second = Integer.parseInt(arr[1]);

    //답을 출력
        System.out.println(first - second);
    }
}