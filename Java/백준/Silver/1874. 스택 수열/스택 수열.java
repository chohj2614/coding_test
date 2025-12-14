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
        int toadd = 1;


        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            // cur까지 push
                while (toadd <= cur) {
                    stack.push(toadd++);
                    sb.append("+\n");
                }

                // 스택 top이 cur이면 pop
                if (stack.peek() == cur) {
                    stack.pop();
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    return;
                }

        }
        System.out.println(sb.toString());
    }
}
