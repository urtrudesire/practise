package code;

import java.util.Arrays;

public class Anagram {

    /**
     *
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     */

    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        return sortString(s).equals(sortString(t));
    }

    private String sortString(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return Arrays.toString(ch);
    }

}
