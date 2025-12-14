import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(br.readLine());
        }
        list.sort(Comparator.comparingInt(String::length).thenComparing(String::compareTo));
        List<String> fin = new ArrayList<>(new LinkedHashSet<>(list));
        for(String s: fin){
            System.out.println(s);
        }
    }
}