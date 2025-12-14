import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String str = br.readLine();
            int prev = 0;
            int sum = 0;
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == 'O'){
                    prev++;
                    sum += prev;
                }  else{
                    prev = 0;
                }
            }
            System.out.println(sum);
        }
    }
}