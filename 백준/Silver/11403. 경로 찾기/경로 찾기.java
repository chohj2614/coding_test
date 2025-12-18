import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.SimpleTimeZone;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        Graph tree = new Graph(n);
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                if(input[j].equals("1")) tree.addEdge(i,j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                boolean[] visited = new boolean[n];
                sb.append((tree.check(i,j,visited) == true? 1 : 0) + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}

class Graph{
    private LinkedList<Integer> adj[];
    private int N;

    public Graph(int n) {
        this.N = n;
        this.adj = new LinkedList[N];
        for(int i =0 ; i < n; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int i, int j){
        this.adj[i].add(j);
    }

    public boolean check(int i, int j, boolean[] visited){
        visited[i] = true;

        for(int next : adj[i]){
            if(next == j)return true;
            if(!visited[next]){
                if(check(next,j,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}