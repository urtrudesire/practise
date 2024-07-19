package code;

public class ReverseString {

    public static String reverseString(String s) {
        char[] ch = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = ch.length-1; i >= 0; i--){
            stringBuilder.append(ch[i]);
        }
        return stringBuilder.toString();
    }
}
