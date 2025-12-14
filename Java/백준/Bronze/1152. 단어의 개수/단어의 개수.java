import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        int count = 1;
        if(input.isEmpty()){
            System.out.println(0);
            return;
        }
        for(char c: input.toCharArray()){
            if (c == ' '){
                count++;
            }
        }
        System.out.println(count);
    }
}