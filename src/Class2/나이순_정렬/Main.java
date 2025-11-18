package Class2.나이순_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<List<String>> nestedList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            List<String> temp = new ArrayList<>();
            String[] newPair = br.readLine().split(" ");
            temp.add(newPair[0]);
            temp.add(newPair[1]);
            nestedList.add(temp);
        }

//        nestedList.sort(Comparator.comparing((List<String> innerList) -> innerList.get(0)));
        nestedList.sort((list1, list2) -> list1.get(0).compareTo(list2.get(0)));

        for(int i =0; i < n; i++){
            System.out.println(nestedList.get(i).get(0) + " " + nestedList.get(i).get(1));
        }
    }
}