import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int[] tracker = new int[26];
        for(int i = 0; i < 26; i++){
            tracker[i] = -1;
        }
        int i = 0;
        for(char c : input.toCharArray()){
            int temp = c - 'a';
            if(tracker[temp] == -1){
                tracker[temp] = i;
            }
            i++;
        }
        for(int j : tracker){
            sb.append(j).append(" ");
        }
        System.out.println(sb.toString());
    }
}