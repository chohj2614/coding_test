package Class2.체스판_다시_칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
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
    //2번 bruteforce
        int min = 0;

        for(int i =0; i < 2; i++){
            int count = 0;
            char start = i==0?'B':'W';
            char cur;
            char prev;
            for(int j = 0; j < board.get(0); j++){
                if(j ==0){
                    prev = start;
                    cur = prev;
                } else {
                    cur = prev=="W"?"B":"W";
                }
                for(char c : bwMap.get(j).toCharArray()){
                    if(c != cur){
                        count++;
                    }
                }
            }
        }
    //min 출력




    }
}