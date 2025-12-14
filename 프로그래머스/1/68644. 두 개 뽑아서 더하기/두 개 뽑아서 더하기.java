import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> comb = new HashSet<>();
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                comb.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[comb.size()];
        int i = 0;
        for(int x: comb){
            answer[i]= x;
            i++;
        }
        Arrays.sort(answer);
        return answer;
    }
}