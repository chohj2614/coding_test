import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double N = Double.parseDouble(br.readLine());
        List<Double> grade = new ArrayList<>();
        String[] nums = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            grade.add(Double.parseDouble(nums[i]));
        }

        double max = Collections.max(grade);
        double sum = 0;
        for(int i = 0; i < grade.size(); i++){
            grade.set(i,(grade.get(i)/max*100));
            sum += grade.get(i);
        }
        System.out.println(sum/grade.size());
//        System.out.println(grade.stream().mapToDouble(Double::doubleValue).average().toString());
    }
}