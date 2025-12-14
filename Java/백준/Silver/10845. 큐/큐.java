
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            switch(line[0]){
                case "push":
                    queue.addLast(Integer.parseInt(line[1]));
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    } else{
                        System.out.println(queue.poll());
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        System.out.println(1);
                    }else {System.out.println(0);}
                    break;
                case "front":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else {System.out.println(queue.peekFirst());}
                    break;
                case "back":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else {System.out.println(queue.peekLast());}
                    break;
            }
        }
    }
}