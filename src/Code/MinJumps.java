package Code;

import java.util.HashMap;
import java.util.Map;

public class MinJumps {
    static int minJumps(int[] arr){
        // your code here
        Map<Integer, Integer> map = new HashMap<>();
        int x = arr[0];
        int sum = x;
        int jump = 0;
        int index = 1;
        while(x != 0) {
            while (x > 0 && sum < arr.length-1) {
                map.put(arr[index], index);
                index++;
                x--;
            }
            if(sum >= arr.length-1){
                return jump;
            }
            int max = 0;
            for(int y : map.keySet()){
                if(max < y-map.get(y)){
                    max = y;
                }
            }
            index = map.get(max) + 1;
            x = max;
            map.clear();
            jump++;
            sum = index + x -1;
        }
        return -1;
    }

    public static void main(String[] args) {
       // int[] arr = {9, 10, 1, 2, 3, 4, 8, 0, 0, 0, 0, 0, 0, 0, 1} ;
        int arr[] = {1, 4, 3, 2, 6, 7};
        System.out.println(minJumps(arr));
    }
}
