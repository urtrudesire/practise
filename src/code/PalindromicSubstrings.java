package code;

public class PalindromicSubstrings {

    /**
     * Given a string s, return the number of palindromic substrings in it.
     *
     * A string is a palindrome when it reads the same backward as forward.
     *
     * A substring is a contiguous sequence of characters within the string.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abc"
     * Output: 3
     * Explanation: Three palindromic strings: "a", "b", "c".
     * Example 2:
     *
     * Input: s = "aaa"
     * Output: 6
     * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 1000
     * s consists of lowercase English letters.
     */

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

    static int result = 0;

    public static int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);
            count(s, i, i+1);
        }
        return result;
    }

    public static void count(String s, int start, int end){
       while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
           result++;
           start--;
           end++;
       }
    }
}
