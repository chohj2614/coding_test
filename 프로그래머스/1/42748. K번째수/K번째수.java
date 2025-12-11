import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int s = commands[i][0] - 1;
            int end = commands[i][1];
            int[] temp = Arrays.copyOfRange(array, s, end);
            Arrays.sort(temp);
            System.out.println(Arrays.toString(temp));
            
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
}