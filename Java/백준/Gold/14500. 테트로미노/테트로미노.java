import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int[][] tetromino1 = {{0,0},{0,1},{0,2},{0,3}}; // 가로 4개
    static int[][] tetromino2 = {{0,0},{0,1},{1,0},{1,1}}; // 정사각형
    static int[][] tetromino3 = {{0,0},{1,0},{2,0},{2,1}}; // L 모양
    static int[][] tetromino4 = {{0,0},{1,0},{1,1},{2,1}}; //
    static int[][] tetromino5 = {{0,0},{0,1},{0,2},{1,1}}; // ㅗ 뒤집은 모양
    static int[][][] shapes = {tetromino1,tetromino2,tetromino3,tetromino4,tetromino5};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            inputs = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        LinkedList<int[][]> collections = new LinkedList<>();
        for(int[][] shape : shapes){
            shape = normalize(shape);
            collections.add(shape);
            collections.add(normalize(reflect(shape)));

            int[][] shape90 = normalize(rotate(shape));
            collections.add(shape90); // 90
            collections.add(normalize(reflect(shape90)));

            int[][] shape180 = normalize(rotate(shape90));
            collections.add(shape180); // 180
            collections.add(normalize(reflect(shape180)));

            int[][] shape270 = normalize(rotate(shape180));
            collections.add(shape270); // 270
            collections.add(normalize(reflect(shape270)));
        }

        System.out.println(findMax(N, M, collections));
    }
    static int findMax(int Y, int X, LinkedList<int[][]> collections){
        int max = Integer.MIN_VALUE;

        for(int y = 0; y < Y; y++){
            for(int x = 0 ; x < X; x++){
                tetrominoLoop:
                for(int[][] shape : collections){
                    int cur = 0;
                    for (int[] step : shape){
                        int dx = x + step[1];
                        int dy = y + step[0];
                        if(dx < X && dx >= 0 && dy < Y && dy >= 0) cur += map[dy][dx];
                        else continue tetrominoLoop; // 다음 테트로미노 시도
                    }
                    max = Math.max(cur, max);
                }
            }
        }
        return max;
    }
    static int[][] normalize(int[][] shape){
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        for(int[] x : shape){
            minY = Math.min(minY,x[0]);
            minX = Math.min(minX,x[1]);
        }

        int[][] noramlized = new int[shape.length][2];
        for (int i = 0; i < shape.length; i++) {
            noramlized[i][0] = shape[i][0] - minY;
            noramlized[i][1] = shape[i][1] - minX;
        }
        return noramlized;
    }
    static int[][] reflect(int[][] shape){
        int[][] reflected = new int[shape.length][2];
        for (int i = 0; i < shape.length; i++) {
            reflected[i][0] = shape[i][0];
            reflected[i][1] = -shape[i][1];
        }
        return reflected;
    }

    static int[][] rotate(int[][] shape){
        int[][] rotated = new int[shape.length][2];
        for (int i = 0; i < shape.length; i++) {
            rotated[i][0] = shape[i][1];
            rotated[i][1] = -shape[i][0];
        }
        return rotated;
    }


}