import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < t; i++){
            int cur = Integer.parseInt(br.readLine());
            cur = cur % 42;
            set.add(cur);
        }
        System.out.println(set.size());
    }
}