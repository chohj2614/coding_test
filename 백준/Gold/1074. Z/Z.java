import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int size = 1 << N; // 2^N
        int R = Integer.parseInt(input[1]); // 목표 row
        int C = Integer.parseInt(input[2]); // 목표 col

        int result = search(size,R,C);

        System.out.println(result);
//        System.out.println(zOrder(size,R,C));
    }
    // ???
//    public static int zOrder(int n, int r, int c){ // 비트 계산 이용
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            ans |= ((r >> i) & 1) << (2*i + 1);
//            ans |= ((c >> i) & 1) << (2*i);
//        }
//        return ans;
//    }
    public static int search(int n, int r, int c){
        if(n == 1 ) return 0; // 쪼갤게 없음
        int half = n / 2; // 사분면 나누기
        int area = half * half; // 사분면 내의 개수

        if(r < half && c < half){ // 위 왼쪽
            return search(half, r, c); // 더할 사분면이 없음
        } else if (r < half && c >= half) {// 위 오른쪽
            return area + search(half, r, c - half); // 왼쪽 사분면 area 더하기
        } else if (r >= half && c < half) {// 아래 왼쪽
            return 2 * area + search(half, r - half, c); // 위의 왼,오 사분면 area 더하기
        } else {// 아래 오른쪽
            return 3 * area + search(half, r - half, c - half); // 아래 오른쪽 뺀 나머지 사분면 area 더하기
        }
    }
}
