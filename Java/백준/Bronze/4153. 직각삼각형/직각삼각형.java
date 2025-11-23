
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //0 0 0 나올때까지 반복
        while(true){
            String[] newLine = br.readLine().split(" ");
            List<Integer> numbs = new ArrayList<>();

            //list로 숫자 3개 저장
            for(int i = 0; i < 3; i++){
                numbs.add(Integer.parseInt(newLine[i]));
            }
            // 숫자가 0 0 0 이면 while loop break
            if(numbs.get(0) == 0 && numbs.get(1) == 0 && numbs.get(2) == 0){
                break;
            }

            // 3개중 최대값 찾기
            int max = Math.max(Math.max(numbs.get(0),numbs.get(1)),numbs.get(2));

            //최대값은 list에서 제거
            numbs.remove(Integer.valueOf(max));

            // a^2 + b^2 = c^2 테스트
            if(Math.pow(numbs.get(0), 2) + Math.pow(numbs.get(1),2) == Math.pow(max,2)){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
        }
    }
}