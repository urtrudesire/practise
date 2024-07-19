package Code;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingSubstringLength {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ohvhjdml"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int len = 1;
        int start = 0;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(start));
        for(int i = 1; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                while (start < i && s.charAt(start) != s.charAt(i)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
                continue;
            }
            set.add(s.charAt(i));
            if(len < set.size()){
                len = set.size();
            }
        }
        return len;
    }
}
