import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<Integer> A = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new));
        int M = Integer.parseInt(br.readLine());
        List<Integer> B = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for(int i = 0; i < M; i++){
            int cur = B.get(i);
            if(A.contains(cur)){
                System.out.println(1);
            }else{System.out.println(0);}
        }

    }
}