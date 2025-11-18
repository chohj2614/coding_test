package Class2.소수_찾기;//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    //입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        int count = 0;
        for(int i =0; i < T; i++){
            int cur = Integer.parseInt(arr[i]);
            int skip = 0;
            for(int j = cur - 1; j > 1; j--){
                if(cur % j == 0){
                    skip = 1;
                    break;
                }
            }
//            if(cur == 1){
//                count++;
//                continue;
//            }
            if(skip == 1 || cur == 1){
                continue;
            }
            count++;
        }


        System.out.println(count);
    }
}