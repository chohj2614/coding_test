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