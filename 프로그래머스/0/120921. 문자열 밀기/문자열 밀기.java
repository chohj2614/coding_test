class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        if(A.equals(B)){
            return 0;
        }
                for(int i = A.length() - 1 ; i > - 1; i--){
                   String temp = A.substring(i, A.length()) + A.substring(0,i);
                    if(temp.equals(B)){
                        answer = A.length() - i;
                        break;
                    }

                }
        return answer;
    }
}