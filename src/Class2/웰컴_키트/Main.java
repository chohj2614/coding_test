package Class2.웰컴_키트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> sizeD = new ArrayList<>();
        String[] newLine = br.readLine().split(" ");
        for(int i = 0; i < 6; i++){
            sizeD.add(Integer.parseInt(newLine[i]));
        }
        int T_order = 0;
        List<Integer> packageAmount = new ArrayList<>();
        newLine = br.readLine().split(" ");
        for(int i =0; i < 2; i++){
            packageAmount.add(Integer.parseInt(newLine[i]));
        }
        for(int x : sizeD){
            int cur = x / packageAmount.get(0);
            int rem = x % packageAmount.get(0);
            if(rem != 0){ cur++;}
            T_order += cur;
        }
        System.out.println(T_order);
        System.out.println(N/packageAmount.get(1) + " " + N%packageAmount.get(1));
    }
}