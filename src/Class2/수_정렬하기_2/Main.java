package Class2.수_정렬하기_2;//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
//        int T = sc.nextInt();
        int T = Integer.parseInt(br.readLine());
//        SortedSet<Integer> sortedNums = new TreeSet<>();
        ArrayList<Integer> numList = new ArrayList<>();
        for(int i =0; i < T; i++){
            int cur = Integer.parseInt(br.readLine());
//            sortedNums.add(cur);
//            int cur = sc.nextInt();
            numList.add(cur);
        }
        Collections.sort(numList);
        for(int x: numList){
//            System.out.println(x);
            sb.append(x).append('\n');
        }
        System.out.print(sb.toString());
//        for(int x : sortedNums){
//            System.out.println(x);
//        }
    }
}