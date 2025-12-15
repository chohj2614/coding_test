import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        List<String> myList= new ArrayList<>();
        for(int i = 0; i < N; i++){
            String[] splitted = br.readLine().split("\\.");
            map.put(splitted[1], map.getOrDefault(splitted[1],0) + 1);
        }
        myList.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for(String s : map.keySet()){
            sb.append(s + " " + map.get(s));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}