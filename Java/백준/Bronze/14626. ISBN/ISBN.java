import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[str.length()];
        int i = 0;
        int mys = 0;
        for(char c: str.toCharArray()){
            if(c == '*'){
                mys = i;
                i++;
                continue;
            }
            arr[i] = c - '0';
            i++;
        }
        int ans = 0;
        for(int j = 0; j < 10; j++){
            int sum = 0;
            arr[mys] = ans;
            for(int x = 0; x < 13; x++){
                sum += arr[x] * (x % 2 == 0 ? 1 : 3);
            }
            if(sum % 10 == 0){
                break;
            }
            ans++;
        }
        System.out.println(ans);
    }
}