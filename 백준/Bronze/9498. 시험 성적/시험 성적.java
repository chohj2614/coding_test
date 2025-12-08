import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int grade = Integer.parseInt(br.readLine());
        if(grade >= 90){
            System.out.println("A");
        } else if (grade >= 80){
            System.out.println("B");
        }else if (grade >= 70){
            System.out.println("C");
        }else if (grade >= 60){
            System.out.println("D");
        }else{
            System.out.println("F");
        }
    }
}