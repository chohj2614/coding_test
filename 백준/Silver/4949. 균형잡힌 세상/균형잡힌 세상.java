import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        while(true){
            String line = br.readLine();
            if(line.equals(".")){
                break;
            }
            boolean yes = true;
            for(char c : line.toCharArray()){
                if(c == '(' || c == '['){
                    stack.push(c);
                } else if (c == ']' || c == ')'){
                    if(stack.isEmpty()){
                        yes = false;
                        break;
                    }
                    char out = stack.pop();
                    if(c == ')' && out != '('){
                        yes = false;
                        break;
                    }
                    if(c == ']' && out != '['){
                        yes = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()){
                yes = false;
            }
            if(yes){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
            stack.clear();
        }
    }
}