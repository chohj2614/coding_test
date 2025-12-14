
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
//        Collections.sort(numGiven);

        int max = 0;
//        int a = 0;
//        int b = 0;
//        int c = 0;

        for(int i = 0; i < n; i++){
            for(int j = 1; j < n; j++){
                for(int k = 2; k < n; k++){
                    if(i == j || i == k || j == k){continue;}
                    int cur = numGiven.get(i) + numGiven.get(j) + numGiven.get(k);
                    if( cur > max && cur <= ceil){
//                        a = numGiven.get(i);
//                        b = numGiven.get(j);
//                        c = numGiven.get(k);
                        max = cur;
                    }
                }
            }
        }
//        System.out.println(a);
//        System.out.println(c);
//        System.out.println(b);
        System.out.println(max);
    }
}