import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    //입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(1);
            return;
        }
        int fac = 6;
        //6, 12, 18
        //1,7,19,37...
        //2 - 2 - 7 1 - 6
        //3 - 8 - 19 7 - 18
        //4 - 20 - 37
        int count = 1;
        while(N > fac){
            N -= fac;
            fac += 6;
            count++;
        }
        if(N > 1){count++;}
        System.out.println(count);
    }
}