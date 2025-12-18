import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 'O' 개수
        int S = Integer.parseInt(br.readLine()); // 문자열 길이
        String str = br.readLine();
//        String pN = "";
//        for(int i =0; i < N; i++){
//            pN += "IO";
//        }
//        pN += "I";
        int oiCount = N;
        int curCount = 0;
        int result = 0;
        int i = 1;
        while(i < S - 1){
            if(str.charAt(i-1) == 'I'
            && str.charAt(i) == 'O'
            && str.charAt(i+1) == 'I'){
                curCount++; // IOI 패턴 수 ++
                if(oiCount == curCount){ // 원하는 패턴수 == 현재 IOI 패턴수
                    result++; // 찾은 패턴 개수 ++
                    curCount--; //겹침 허용
                }
                i += 2; // IOI 에서 다음 OI로 넘어감
            }else{
                curCount = 0; // IOI 패턴 수 초기화
                i++;
            }
        }
//        while(str.contains(pN)){ // contain, indexOf, subString : 모두 O(N) -> 시간 많이 잡아먹음
//            str = str.substring(str.indexOf(pN) + 1);
//            count++;
//        }
        System.out.println(result);
    }
}