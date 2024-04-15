package Code;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix ob = new LongestCommonPrefix();
        String[] s = {"cir","car"};
        System.out.println(ob.longestCommonPrefix(s));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String check = strs[0];
        int index = 1;
        while(index < strs.length){
            StringBuilder sb = new StringBuilder();
            String temp = strs[index];
            int x = 0;
            while(x < check.length() && x < temp.length()){
                if(check.charAt(x) == temp.charAt(x)){
                    sb.append(check.charAt(x));
                    x++;
                } else if(sb.isEmpty()){
                    return "";
                } else
                    break;
            }
            check = sb.toString();
            index++;
        }
        return check;
    }
}
