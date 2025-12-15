import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] chunk = input.split("[-]");
        int sum = sumChunk(chunk[0]);
        for(int i = 1; i < chunk.length; i++){
            sum -= sumChunk(chunk[i]);
        }
        System.out.println(sum);
    }
    public static int sumChunk(String s){
        String[] chunks = s.split("[+]");
        int sum = 0;
        for(int i = 0; i < chunks.length; i++){
            sum += Integer.parseInt(chunks[i]);
        }
        return sum;
    }
}