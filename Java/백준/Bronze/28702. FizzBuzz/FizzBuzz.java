import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = new String[3];
        for(int i =0; i < 3; i++){
            inputs[i] = br.readLine();
        }
        int idxNum = 0;
        for(int i = 0; i < 3; i++){
            if(inputs[i].contains("z")){
                continue;
            }
            idxNum = i;
        }
//        3, 5 배수 = FizzBuzz
//        5 배수 = Fizz
//        3 배수 = Buzz
        int num = Integer.parseInt(inputs[idxNum]);
        num += 3 - idxNum;
        if(num % 3 == 0 && num % 5 == 0){
            System.out.println("FizzBuzz");
        } else if(num % 3 == 0){
            System.out.println("Fizz");
        } else if(num % 5 == 0){
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }
    }
}