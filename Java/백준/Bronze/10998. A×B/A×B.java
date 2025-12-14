import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] newLine = br.readLine().split(" ");
        System.out.println(Integer.parseInt(newLine[0]) * Integer.parseInt(newLine[1]));
        return;

    }
}