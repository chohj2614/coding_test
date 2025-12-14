import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

class Person{
    String name;
    int age;
    Person(int age, String name){
        this.name = name;
        this.age = age;
    }
}
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
//        List<List<String>> nestedList = new ArrayList<>();
        List<Person> people = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String[] newPair = br.readLine().split(" ");
            Person cur = new Person(Integer.parseInt(newPair[0]), newPair[1]);
            people.add(cur);
//            List<String> temp = new ArrayList<>();
//            String[] newPair = br.readLine().split(" ");
//            temp.add(newPair[0]);
//            temp.add(Integer.parseInt(newPair[1]));
//            nestedList.add(temp);
        }
        people.sort(Comparator.comparing((person) -> person.age));
//        nestedList.sort(Comparator.comparing((List<String> innerList) -> innerList.get(0)));
//        nestedList.sort((list1, list2) -> list1.get(0).compareTo(list2.get(0)));
//
        for(int i =0; i < n - 1; i++){
//            sb.append(nestedList.get(i).get(0)).append(" ").append(nestedList.get(i).get(1)).append("\n");
            sb.append(people.get(i).age).append(" ").append(people.get(i).name).append("\n");

//            System.out.println(nestedList.get(i).get(0) + " " + nestedList.get(i).get(1));
        }
        sb.append(people.get(n-1).age).append(" ").append(people.get(n-1).name);
//        sb.append(nestedList.get(n-1).get(0)).append(" ").append(nestedList.get(n-1).get(1));
        System.out.print(sb.toString());
    }
}