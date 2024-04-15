package Code;

public class LongestPalindromicSubstring {

    /**
     * Given a string s, return the longest
     * palindromic
     *
     * substring
     *  in s.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: s = "cbbd"
     * Output: "bb"
     */

    public static void main(String[] args) {
        String s = "321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123";
        System.out.println(getLPS(s));
    }

    private static String getLPS(String s) {
        if(s.length() < 2){
            return s;
        }
        String oddLengthPalindrome = checkForOddLength(s);
        String evenLengthPalindrome = checkForEvenLength(s);
        return oddLengthPalindrome.length() > evenLengthPalindrome.length() ? oddLengthPalindrome : evenLengthPalindrome;
    }

    private static String checkForEvenLength(String s) {
        String res = "";
        if(s.length() == 2 && s.charAt(0) == s.charAt(1)){
            return s;
        }
        for(int i = 1; i < s.length(); i++){
            if (s.charAt(i-1) == s.charAt(i)){
                if(res.length() < 2){
                    res = s.substring(i-1, i+1);
                }
                int l = i-2, r = i+1;
                while (l >= 0 && r < s.length()) {
                    if(s.charAt(l) == s.charAt(r)){
                        if(r-l+1 > res.length()){
                            res = s.substring(l, r+1);
                        }
                        l--;
                        r++;
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }

    private static String checkForOddLength(String s) {
        String res = s.substring(0, 1);
        if(s.length() <= 2){
            return res;
        }
        for(int i = 1; i < s.length(); i++){
            int l = i-1, r = i+1;
            while(l >= 0 && r < s.length()){
                if(s.charAt(l) == s.charAt(r)){
                    if(r-l+1 > res.length()){
                        res = s.substring(l, r+1);
                    }
                    l--;
                    r++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
