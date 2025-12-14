import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> inputs = new ArrayList<>();

        for(int i = 0; i< N; i++){
            List<Integer> temp = new ArrayList<>();
            String[] newLine = br.readLine().split(" ");
            temp.add(Integer.parseInt(newLine[0]));
            temp.add(Integer.parseInt(newLine[1]));
            inputs.add(temp);
        }

        for(int i = 0; i < N; i++){
            sb.append(countGreater(inputs, i, N) + 1 + " ");
        }

        System.out.println(sb.toString());

    }
    static int countGreater(List<List<Integer>> people, int idx, int N){
        int count = 0;
        int cur_weight = people.get(idx).get(0);
        int cur_height = people.get(idx).get(1);
        for(int i = 0; i < N; i++){
            if(i == idx){ // 같은 사람
                continue;
            }
            int weight_compare = people.get(i).get(0);
            int height_compare = people.get(i).get(1);
            // 비교군과 키,몸무게 같을 경우
            if(weight_compare == cur_weight && height_compare == cur_height){
                continue;
            }
            if(cur_weight < weight_compare && cur_height < height_compare){
                count++;
            }
        }
        return count;
    }
}