import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        while(sc.hasNext()){
            int x = sc.nextInt();
            if(x == 0)break;
            List<Integer> numList = new ArrayList<>();
            for(int i = 0; i < x; i++){
                numList.add(sc.nextInt());
            }
            List<List<Integer>>  doubleL = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            combi(numList, 6, doubleL, temp, 0);
            for (List<Integer> list : doubleL){
                for(Integer num : list){
                    sb.append(num+" ");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
    public static void combi(List<Integer> myList, int n, List<List<Integer>> doubleL, List<Integer> temp, int x){
        if(temp.size() == n){
            doubleL.add(new ArrayList<>(temp));
            return;
        }
        for(int i = x; i < myList.size(); i++){
            temp.add(myList.get(i));
            combi(myList, n, doubleL, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}