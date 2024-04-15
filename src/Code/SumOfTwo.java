package Code;

public class SumOfTwo {

    /**
     *Given two integers a and b, return the sum of the two integers without using the operators + and -.
     */

    public static void main(String[] args) {
        System.out.println(getSum(8, 9));
    }

    public static int getSum(int a, int b) {
        int sum = a^b;
        int carry = a & b;
        if( carry == 0) return sum;
        return getSum(sum, carry << 1);
    }
}
