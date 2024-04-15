package Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        List<List<Integer>> o;
        o = t.threeSum(new int[]{0, 0, 0});
        for(List<Integer> z : o){
            System.out.println(z.toString());
        }
    }

    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < num.length-2; i++){
            if(i == 0 || num[i] != num[i - 1]){
                int low = i+1;
                int high = num.length-1;
                int sum = -num[i];
                while(low < high){
                    if(num[low] + num[high] == sum){
                        res.add(Arrays.asList(num[i], num[low], num[high]));
                        while(low < high && num[low] == num[low+1]) low++;
                        while(low < high && num[high] == num[high-1]) high--;
                        low++;
                        high--;
                    }
                    else if(num[low] + num[high] > sum){
                        high--;
                    }
                    else
                        low++;
                }
            }
        }
        return res;
    }
}
