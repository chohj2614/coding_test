import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i: arr){
            if(!stack.isEmpty()){
                if(i == stack.peek()){
                    continue;
                } else {
                    stack.push(i);
                }
            }else {
                stack.push(i);
            }
        }
        int[] answer = new int[stack.size()];
        int i = stack.size() - 1;
        while(!stack.isEmpty()){
            answer[i] = stack.pop();
            i--;
        }
        return answer;
    }
}
