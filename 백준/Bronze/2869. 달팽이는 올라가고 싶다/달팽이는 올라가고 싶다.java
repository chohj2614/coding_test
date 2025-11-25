import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int V = Integer.parseInt(str[2]);
//        int count = 1;
//        while(V>0){
//            V -= A;
//            if(V <= 0){
//                break;
//            }
//            V += B;
//            count++;
//        }
        int count = (int)Math.ceil((V - A) / (double)(A-B))  + 1;

        System.out.println(count);
    }
}