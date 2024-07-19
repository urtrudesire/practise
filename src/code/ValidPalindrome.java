package code;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isValidPalindrome("0p"));
    }

    public static boolean isValidPalindrome(String s){
        int start = 0;
        s = s.toLowerCase();
        int length = s.length();
        int end = length-1;
        boolean check = false;
        if(s.isEmpty()){
            return false;
        }
        if(length == 1){
            return false;
        }
        while (start < end){
            while (start < end && isSpecialChar(s.charAt(start)) ) {
                start++;
                if(start == end)
                    break;
            }
            while (end > start && isSpecialChar(s.charAt(end))){
                end--;
                if(start == end)
                    break;
            }
            char sChar = s.charAt(start);
            char eChar = s.charAt(end);
            if(sChar != eChar)
                return false;
            else {
                if(start != end)
                    check = true;
            }
            start++;
            end--;
        }
        return check;
    }

    private static boolean isSpecialChar(char c){
        return (c < 'a' || c > 'z');
    }
}
