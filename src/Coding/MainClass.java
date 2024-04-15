package Coding;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainClass {

    public static void main(String[] args) {
        Map<Solulever, String> map = new TreeMap<>(new Comp());
        Map<String, String> finalMap = new HashMap<>();
        finalMap.put("a", "b");
        Solulever s1 = new Solulever("Shivam", finalMap);
        finalMap.put("a", "c");

        System.out.println(s1.toString());

        map.put(s1, "dsfwwsd");
        map.forEach((k, v) -> System.out.println(k.getName() + " " + v) );
    }

}
