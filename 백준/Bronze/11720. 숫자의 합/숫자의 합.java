import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String temp = br.readLine();
        char[] num = temp.toCharArray();
        int sum = 0;
        for(int i = 0; i < len; i++){
            int cur = num[i] - '0';
            sum = cur + sum;
        }

        System.out.print(sum);
    }
}