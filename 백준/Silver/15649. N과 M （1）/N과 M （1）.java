import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        List<Integer> numList = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            numList.add(i);
        }
        List<List<Integer>>  doubleL = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[N];
        permu(numList, M, doubleL, temp, visited);
        for (List<Integer> list : doubleL){
            for(Integer x : list){
                sb.append(x+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void permu(List<Integer> myList, int n, List<List<Integer>> doubleL, List<Integer> temp, boolean[] visited){
        if(temp.size() == n){
            doubleL.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < myList.size(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            temp.add(myList.get(i));
            permu(myList, n, doubleL, temp, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

}