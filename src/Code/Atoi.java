package Code;

public class Atoi {
    public static void main(String[] args) {
        System.out.println(myAtoi(" -4193"));
    }
    public static int myAtoi(String s) {
        double res = 0.0;
        int index =0;
        while(index < s.length()){
            if(s.charAt(index) == ' ')
                index++;
            else
                break;
        }
        s = s.substring(index);
        if(s.isEmpty()) {
            return 0;
        }
        index = 0;
        boolean positive = true;
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            index++;
            if(s.charAt(0) == '-'){
                positive = false;
            }
        }
        while(index < s.length()){
            if(s.charAt(index) == '.')
                break;
            int c = s.charAt(index) - 48;
            if(c < 0 || c > 9){
                return getNumber(positive, res);
            }
            res = res*10 + (s.charAt(index)-48);
            index++;
        }
        return getNumber(positive,res);
    }

    private static int getNumber(boolean positive, double res) {
        if(!positive){
            res = -res;
        }
        if( res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if( res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) res;
    }
}
