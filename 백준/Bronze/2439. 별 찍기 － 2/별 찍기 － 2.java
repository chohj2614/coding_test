import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    //입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        char s = '*';
        char e = ' ';

        for(int i = 0; i < n; i++){
            String temp = "";
            for(int j = n - i - 1; j > 0; j--){
                temp = temp + e;
            }
            for(int j = 1; j <= i + 1; j++ ){
                temp = temp + s;
            }
            System.out.println(temp);
        }
    }
}