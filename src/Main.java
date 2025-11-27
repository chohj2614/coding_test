import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> toadd = new Stack<>();
        for (int i = N; i > 0; i--) {
            toadd.add(i);
        }

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (stack.isEmpty()) {
                stack.push(toadd.pop());
                sb.append("+\n");
            }
            if(stack.peek() == cur){
                stack.pop();
                sb.append("-\n");
            } else if (stack.peek() > cur){
                while (stack.peek() != cur) {
                    if (toadd.isEmpty()) {
                        System.out.println("NO");
                        return;
                    }
                    stack.push(toadd.pop());
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb.toString());
    }
}
