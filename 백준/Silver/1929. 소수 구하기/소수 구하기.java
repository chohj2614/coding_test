import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int M = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);
        int[] check = new int[N+2];
        for(int i = 0; i < N+2; i++){
            check[i] = 1;
        }
//        System.out.println("sqrt = " + (int)Math.sqrt(N));

        for(int i = 2; i <= Math.sqrt(N); i++){
            int x = i;
            while(x*i <= N){
                check[x*i] = 0;
//                System.out.println("x= " + x + " i = " + i + " " + "x*i = " + x*i);
                x++;
            }
        }
        for(int i = M; i <= N; i++){
            if(i == 1){
                continue;
            }
            if(check[i] != 0){
//                System.out.println("i = " + i + " check[i] = " + check[i]);
                System.out.println(i);
            }
        }
    }
}