package Code;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {

    public static void main(String[] args) {
        String c = "NFANDROID2-PRV-USW4071ATL-MGK00000000000000000000000000000000841";
        PhoneNumber p = new PhoneNumber();
        String l = "23";
        System.out.println(p.letterCombinations(l).size());
        for(String t : p.letterCombinations(l))
            System.out.println(t);
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()){
            return res;
        }
        int[] t = new int[digits.length()];
        String[] base = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res = getCombination(base, digits);
        return res;
    }

    private List<String> getCombination(String[] base, String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty())
            return res;
        int n = digits.charAt(0)- 50;
        List<String> x = getCombination(base, digits.substring(1));
        for(char c : base[n].toCharArray()){
            if(x.isEmpty()){
                res.add(String.valueOf(c));
            } else {
                for(String v : x){
                    res.add(String.valueOf(c) + v);
                }
            }
        }

        return res;
    }
}
