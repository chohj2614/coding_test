import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException {
        Scanner input = new Scanner(System.in);
        String curLine;

        while(input.hasNextLine()){
            curLine = input.nextLine();
            String[] cur = curLine.split(" ");
            int a = Integer.parseInt(cur[0]);
            int b = Integer.parseInt(cur[1]);
            System.out.println(a+b);
        }
    }
}
