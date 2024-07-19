package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwinStrings {

    final Map<Character , Integer> evenMap = new HashMap<>();
    final Map<Character , Integer> oddMap = new HashMap<>();

    public static void main(String[] args) {
        TwinStrings ob = new TwinStrings();
        ob.getTwinString(List.of("abcd", "abcd"), List.of("cbad", "bacd"));
    }

    public void getTwinString(List<String> a , List<String> b){
        List<String> res = new ArrayList<>();
        for(int i = 0 ; i < a.size(); i++){
            evenMap.clear();
            oddMap.clear();
            String x = a.get(i);
            String y = b.get(i);
            if(x.length() != y.length()){
                res.add("No");
                System.out.println("No");
            }else {
                for(int j = 0 ; j < x.length(); j++){
                    char c = x.charAt(j);
                    char d = y.charAt(j);
                    if(j%2 == 0){
                        computeMap(evenMap, c, d);
                    }else {
                        computeMap(oddMap, c, d);
                    }
                }
                if (evenMap.isEmpty() && oddMap.isEmpty()){
                    res.add("Yes");
                    System.out.println("Yes");
                } else {
                    res.add("No");
                    System.out.println("No");
                }
            }
        }
    }

    private void computeMap(Map<Character, Integer> map, char c, char d) {
        if(map.containsKey(c)){
            int value = map.get(c);
            value++;
            if(value == 0){
                map.remove(c);
            }else {
                map.put(c, value);
            }
        } else {
            map.put(c , 1);
        }
        if(map.containsKey(d)){
            int value = map.get(d);
            value--;
            if(value == 0){
                map.remove(d);
            }else {
                map.put(d, value);
            }
        } else {
            map.put(d, -1);
        }
    }
}
