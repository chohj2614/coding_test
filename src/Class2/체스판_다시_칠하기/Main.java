package Class2.체스판_다시_칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] board = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()).toArray();
        int count = 0;
        int min = 0;
        String[] bw = {"W", "B"};
        for(int i = 0; i < 2; i++){
            String start = bw[i];

        }

    }
}