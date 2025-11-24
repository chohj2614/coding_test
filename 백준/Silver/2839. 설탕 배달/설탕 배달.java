import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max_5 = N / 5;
        int max_3 = N / 3;
        int min = Integer.MAX_VALUE;
        boolean found = false;
        for(int five = 0; five <= max_5; five++){
            int count = 0;
            for(int thr = 0; thr <= max_3; thr++){
                int cur = N;
                cur -= 5 * five;
                cur -= 3 * thr;
                if(cur != 0){
                    continue;
                }
                found = true;
                count = five + thr;
                min = Math.min(min, count);
            }
        }
        if(!found){
            min = -1;
        }
        System.out.println(min);
    }
}