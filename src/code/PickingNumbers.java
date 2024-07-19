package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        Collections.sort(a);
        int max = 0;
        int temp = 0;
        int start = 0 , end = 1;
        while ( end < a.size()){
            int dif = Math.abs(a.get(start) - a.get(end));
            if(dif == 1){
                temp++;
                end++;
            } else if (start < end && dif > 0){
                if(temp > max)
                    max = temp;
                start++;
                temp--;
            } else
                end ++;
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(6);
        list.add(5);
        list.add(3);
        list.add(3);
        list.add(1);
        pickingNumbers(list);
    }
}
