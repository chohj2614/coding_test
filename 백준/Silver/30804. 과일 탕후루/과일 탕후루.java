import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];
//        int[] count = new int[N+1]; // N은 주어진 과일 수와 상관이 없음 -> arrayIndexOutofBounds 에러 터짐
        int[] count = new int[10]; //과일 종류 : 1~9 -> 10개
        int kind = 0;
        String[] inputs = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(inputs[i]);
            fruits[i] = temp;
        }

        int max = Integer.MIN_VALUE;
        int l = 0;
        for(int r = 0; r < fruits.length; r++){
            if(count[fruits[r]]++ == 0){ // 확인 후 count ++
                kind++; // 해당 과일이 없었으면 종류 ++
            }
            while(kind > 2){
                if(--count[fruits[l]] == 0){ // 확인 전 count --
                    kind--;
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
//        for(int l = 0; l < fruits.length - 1; l++){
//            for(int r = fruits.length; r > 1 ; r--){ // O(N^2) -> 시간초과
//                if(check(l,r,fruits)){
//                    if(max > (r-l)){
//                        break;
//                    }
//                    max = Math.max(max, r-l);
////                    System.out.println(max + " l : " + l + " r: " + r);
//                }
//            }
//        }

        System.out.println(max);
    }

    // check 메서드 안에서 int[]를 iterate 하면 시간소요가 더 커져서 기각
//    public static boolean check(int l, int r, int[] arr){
//        int one = 0;
//        int two = 0;
//        for(int i = l; i < r; i++){
//            int cur = arr[i];
//            if(one == 0){
//                one = cur;
//                continue;
//            }
//            if(two == 0 && one != cur){
//                two = cur;
//                continue;
//            } else if(cur != one && cur != two){
//                return false;
//            }
//       }
//        return true;
//    }
}