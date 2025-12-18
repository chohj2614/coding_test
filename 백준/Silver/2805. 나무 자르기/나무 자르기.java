import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        long[] trees = new long[N]; //long 안하면 overflow
        for(int i =0; i < N; i++){
            trees[i] = Long.parseLong(input[i]);
        }
        Arrays.sort(trees);
        long Hl = 0;
        long Hr = trees[trees.length-1]; // 최대 높이
        long result = 0;
        while(Hl <= Hr){
            long m = (Hl + Hr)/2;
            if(check(m,M,trees)){
                Hl = m + 1;
                result = m;
            } else {
                Hr = m -1;
            }
        }

        System.out.println(result);
    }
    public static boolean check(long H, long M, long[] trees){
        long sum = 0;
        for(long x : trees){
            if(x > H){
                sum += x - H;
            }
        }
        if(sum >= M) return true;
        return false;
    }
}