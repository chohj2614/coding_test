package A_plus_B_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String temp = "";
        for(int i = 0; i < input.length - 1; i++){
            int a = Integer.parseInt(input[i]);
            int b = Integer.parseInt(input[i+1]);

            if(a < b && temp != "descending"){
                temp = "ascending";
            }
            else if(a > b && temp != "ascending"){
                temp = "descending";
            } else{
                temp = "mixed";
                break;
            }
        }
        System.out.println(temp);
    }
}
