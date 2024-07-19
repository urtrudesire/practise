package code;

public class ReverseInteger {

    public static void main(String[] args) {
        int x = -123456;
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(x));
    }

    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        double rev = 0f;
        boolean neg = x < 0;
        while(x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        if(neg){
            rev = -rev;
        }
        if( rev > max || rev < min)
            return 0;
        return neg?-(int) rev : (int) rev;
    }
}
