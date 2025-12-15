import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> temp = new ArrayList<>();
        for(int i: arr){
            if(!stack.isEmpty()){
                if(i == stack.peek()){
                    continue;
                } else {
                    stack.push(i);
                    temp.add(i);
                }
            }else {
                stack.push(i);
                temp.add(i);
            }
        }
        int[] answer = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            answer[i] = temp.get(i);
        }
        return answer;
    }
}