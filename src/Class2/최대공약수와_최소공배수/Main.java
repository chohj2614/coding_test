package Class2.최대공약수와_최소공배수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int temp = Math.min(a,b);
        int max_div = 0;
        int min_mul =0;
        for(int i = temp; i > 0; i--){
            if(a%i == 0 && b % i == 0){
                max_div = i;
                break;
            }
        }
        temp = Math.max(a,b);
        for(int i = temp; i< a*b; i++){
            if(i % a == 0 && i % b == 0){
                min_mul = i;
                break;
            }
        }
        if(min_mul == 0){min_mul = a*b;}
        System.out.println(max_div + "\n" + min_mul);
    }
}