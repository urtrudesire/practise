package code;

public class DecodeWays {
    /**
     * A message containing letters from A-Z can be encoded into numbers using the following mapping:
     *
     * 'A' -> "1"
     * 'B' -> "2"
     * ...
     * 'Z' -> "26"
     * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
     *
     * "AAJF" with the grouping (1 1 10 6)
     * "KJF" with the grouping (11 10 6)
     * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
     *
     * Given a string s containing only digits, return the number of ways to decode it.
     *
     * The test cases are generated so that the answer fits in a 32-bit integer.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "12"
     * Output: 2
     * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
     * Example 2:
     *
     * Input: s = "226"
     * Output: 3
     * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     * Example 3:
     *
     * Input: s = "06"
     * Output: 0
     * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
     */

    public static void main(String[] args) {
        DecodeWays ob = new DecodeWays();
        System.out.println(ob.numDecodings("12"));
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        for(int i =0; i < s.length(); i++){
            dp[i] = -1;
        }
        return getStrings(s, 0, dp);
    }

    private int getStrings(String s, int i, int[] dp) {
        int count = 0;
        if(i >= s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0'){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        if(checkForCurrent(i,s)) {
            count += getStrings(s, i + 1, dp);
        }
        if(checkForTwoDigit(i, s)){
            int c = Integer.parseInt(s.substring(i, i+2));
            if(c < 27){
                count += getStrings(s, i+2, dp);

            }
        }
        dp[i] = count;
        return count;
    }

    private boolean checkForTwoDigit(int i, String s) {
        if(i < s.length()-1){
            if(i < s.length()-2 && s.charAt(i+2) == '0'){
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean checkForCurrent(int i, String s) {
        if( i == s.length()-1){
            return true;
        }
        return s.charAt(i + 1) != '0';
    }


}
