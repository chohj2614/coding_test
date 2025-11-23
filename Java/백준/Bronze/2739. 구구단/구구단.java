import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        for (int i = 1; i < 10; i++) {
            int temp = n * i;
            System.out.println(n + " * " + i + " = " + temp);
        }
    }
}