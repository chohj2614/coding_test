package Class2.이항_계수_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int fact(int x){
        int prod = 1;
        for(int i = x; i > 1; i--){
            prod *= i;
        }
        return prod;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] newLine = br.readLine().split(" ");
        int a = Integer.parseInt(newLine[0]);
        int b = Integer.parseInt(newLine[1]);
        System.out.println(fact(a)/fact(a-b)/fact(b));
    }
}