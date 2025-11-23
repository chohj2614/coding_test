import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static void countMin(List<Integer> board, int sx, int sy){
        //bruteforce 2번
        int min = 0;

        for(int i =0; i < 2; i++){
            int count = 0;
            char start = i==0?'B':'W';
            char cur;
            char prev = 'W';
            for(int j = 0; j < board.get(0); j++){
                if(j ==0){
                    prev = start;
                    cur = prev;
                } else {
                    cur = prev=='W'?'B':'W';
                    prev = cur;
                }
                for(char c : bwMap.get(j).toCharArray()){
                    if(c != cur){
                        count++;
                    }
                    cur = cur=='W'?'B':'W';
                }
            }
            if(i == 0){
                min = count;
            }else {
                if(min > count){
                    min = count;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //보드 숫자 받기
        List<Integer> board = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //보드 맵 받기
        List<String> bwMap = new ArrayList<>();
        for(int i = 0; i < board.get(0); i++){
            bwMap.add(br.readLine());
        }

        //8x8로 반복


        //min 출력
        System.out.println(min);
    }
}