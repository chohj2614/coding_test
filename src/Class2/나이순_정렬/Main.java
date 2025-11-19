package Class2.나이순_정렬;

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
        List<Person> people = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String[] newPair = br.readLine().split(" ");
            Person cur = new Person(Integer.parseInt(newPair[0]), newPair[1]);
            people.add(cur);
        }
        people.sort(Comparator.comparing((person) -> person.age));

        for(int i =0; i < n - 1; i++){
            sb.append(people.get(i).age).append(" ").append(people.get(i).name).append("\n");
        }
        sb.append(people.get(n-1).age).append(" ").append(people.get(n-1).name);
        System.out.print(sb.toString());
    }
}