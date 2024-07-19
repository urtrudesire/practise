package code;

public class DivideInteger {

    public static void main(String[] args) {
        DivideInteger d = new DivideInteger();
        System.out.println(d.divide(-2147483648, -1));
    }

    public int divide(int dividend, int divisor) {
        int ans = 0;
        if(divisor == 1){
            return dividend;
        }
        if (divisor == -1){
            if(dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
        }
        boolean neg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        if(dividend == Integer.MIN_VALUE){
            dividend -= Math.abs(divisor);
            ans++;
        }
        if(divisor == Integer.MIN_VALUE)
            return 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(dividend >= divisor){
            dividend -= divisor;
            ans++;
            if(ans == Integer.MAX_VALUE)
                return neg?-ans: ans;
        }
        return neg?-ans:ans;
    }
}
