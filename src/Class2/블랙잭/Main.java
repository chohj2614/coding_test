package Class2.블랙잭;//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] newLine = br.readLine().split(" ");

        int n = Integer.parseInt(newLine[0]);
        int ceil = Integer.parseInt(newLine[1]);

        List<Integer> numGiven = new ArrayList<>();
        newLine = br.readLine().split(" ");

        for(String c: newLine){
            numGiven.add(Integer.parseInt(c));
        }

        int max = 0;

        for(int i = 0; i < n; i++){
            for(int j = 1; j < n; j++){
                for(int k = 2; k < n; k++){
                    if(i == j || i == k || j == k){continue;}
                    int cur = numGiven.get(i) + numGiven.get(j) + numGiven.get(k);
                    if( cur > max && cur <= ceil){
                        max = cur;
                    }
                }
            }
        }
        System.out.println(max);
    }
}