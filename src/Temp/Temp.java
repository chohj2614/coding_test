package Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Temp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int M = Integer.parseInt(br.readLine());

        Family fam = new Family(N);

        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            fam.addChild(n,c);
        }
        int count = 0;
        count = fam.DFS(a, b, count);
        System.out.println(count);
    }

    public static class Family{
        private int N;
        private LinkedList<Integer> children[];
        private boolean[] visited;

        Family(int n){
            N = n;
            children = new LinkedList[N + 1];
            visited = new boolean[N + 1];
            Arrays.fill(visited, Boolean.FALSE);

            for(int i = 0; i <= N; i++){
                children[i] = new LinkedList<>();
            }
        }

        void addChild(int n, int c){
            children[n].add(c);
            children[c].add(n);
        }

        int DFS(int n, int c, int count){
            if(n == c){
                return count;
            }
            visited[n] = true;
            for(int child : children[n]){
                if(!visited[child]){
                    int result = DFS(child, c, count + 1);
                    if(result != -1) return result;
                }
            }
            return -1;
        }
    }
}