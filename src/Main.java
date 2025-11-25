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
//        } loop 쓰면 시간 초과
        int count = (int)Math.ceil((V - A) / (double)(A-B))  + 1;
                // V- A : 마지막 날 올라갔을 높이를 차감
                // A-B 로서 마지막 날 까지 필요한 날짜
                // 1 : 첫날도 포함이라 +1
        System.out.println(count);
    }
}