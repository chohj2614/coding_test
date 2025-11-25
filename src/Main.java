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

    }
}