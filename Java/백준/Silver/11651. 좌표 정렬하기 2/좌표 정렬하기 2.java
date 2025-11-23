import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<List<Integer>> nestedList = new ArrayList<>();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            List<Integer> tempList = new ArrayList<>();
            tempList.add(a);
            tempList.add(b);
            nestedList.add(tempList);
        }
        nestedList.sort(Comparator.comparing((List<Integer> innerList) -> innerList.get(1))
                .thenComparing((List<Integer> innerList)-> innerList.get(0)));
        for(List<Integer> inner : nestedList){
            sb.append(inner.get(0)).append(" ").append(inner.get(1)).append("\n");
        }
        System.out.print(sb.toString());
    }
}