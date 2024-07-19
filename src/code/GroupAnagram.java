package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */

    public static void main(String[] args) {
        String[] strs = {""};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result.size());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length == 0){
            return res;
        }
        if(strs.length == 1){
            res.add(Arrays.asList(strs));
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for(String s : strs){
            String temp = sortString(s);
            if(map.containsKey(temp)){
                int i = map.get(temp);
                res.get(i).add(s);
            } else {
                map.put(temp, index);
                index++;
                List<String> t = new ArrayList<>();
                t.add(s);
                res.add(t);
            }
        }
        return res;
    }

    private static String sortString(String s) {
        char[] chr = s.toCharArray();
        Arrays.sort(chr);
        return new String(chr);
    }
}
