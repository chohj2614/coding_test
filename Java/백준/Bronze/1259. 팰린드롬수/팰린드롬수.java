import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            char[] newLine = br.readLine().toCharArray();
            if(newLine[0] == '0'){break;}
            int len = newLine.length;
            boolean yes = true;
            for(int i = 0; i < len; i++){
                if(i == len - i - 1){break;}
                if(newLine[i] != newLine[len - i - 1]){
                    yes = false;
                }
            }
            if(yes){
                System.out.println("yes");
            } else{
                System.out.println("no");
            }

        }
    }
}