package code;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] arr = {2,3,5};
        int target = 8;
        List<List<Integer>> ans = new ArrayList<>();
        getCombination(arr, target, new ArrayList<>(), arr.length-1, ans);
        for (List<Integer> l : ans){
            for(Integer c : l){
                System.out.print(c + " ");
            }
            System.out.println();
        }
        //System.out.println(ans.size());
    }

    private static void getCombination(int[] arr, int target, List<Integer> res, int index, List<List<Integer>> ans){
            if (target == 0) {
                ans.add(new ArrayList<>(res));
                return;
            }
            if(index < 0)
                return;

        if(arr[index] <= target){
            res.add(arr[index]);
            getCombination(arr, target-arr[index], res, index, ans);
            res.remove(res.size()-1);
        }
        getCombination(arr, target,res, index-1, ans);
    }
}
