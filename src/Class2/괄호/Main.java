package Class2.괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String[] cur = br.readLine().split(" ");
            int l = 0;
            boolean yes = true;
            for(String s : cur){
                if(s.equals("(")){
                    l++;
                }
                if(s.equals(")") && l > 0){
                    l--;
                }else{
                    yes = false;
                }
            }
            if(yes){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}