package Code;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromString {

    /**
     * Given a string str which may contains lowercase and uppercase chracters. The task is to remove all duplicate characters from the string and find the resultant string. The order of remaining characters in the output should be same as in the original string.
     *
     * Example 1:
     *
     * Input:
     * str = "geEksforGEeks"
     * Output:
     * "geEksforG"
     * Explanation:
     * After removing duplicate characters such as E, e, k, s, we have string as "geEksforG".
     * Example 2:
     *
     * Input:
     * str = "HaPpyNewYear"
     * Output:
     * "HaPpyNewYr"
     * Explanation:
     * After removing duplicate characters such as e, a, we have string as "HaPpyNewYr".
     */

    public String removeDuplicates(String str) {
        Set<Character> charSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : str.toCharArray()){
            if(!charSet.contains(c)){
                stringBuilder.append(c);
                charSet.add(c);
            }
        }
        return stringBuilder.toString();
    }
}
