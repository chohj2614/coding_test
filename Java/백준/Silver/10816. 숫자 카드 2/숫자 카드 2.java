import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> given = new HashMap<Integer, Integer>();
        String[] newLine = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            int cur = Integer.parseInt(newLine[i]);
            if(given.containsKey(cur)){
                given.put(cur, given.get(cur) + 1);
            } else {
                given.put(cur,1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        newLine = br.readLine().split(" ");
        for(int i = 0; i < M; i++){
            int cur = Integer.parseInt(newLine[i]);
            if(given.containsKey(cur)){
                sb.append(given.get(cur)).append(" ");
            }else {
                sb.append("0 ");
            }
        }
        System.out.println(sb.toString());

    }
}