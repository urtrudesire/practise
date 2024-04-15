package Code;

public class Power {

    public static void main(String[] args) {

        System.out.println(power(3, 1));
    }

    private static long power(int x , int n){
        if(n == 0 || x == 1){
            return 1;
        }
        long temp = power(x, n/2);
        if(n % 2 == 0){
            return temp * temp;
        }else {
            if(n > 0){
                return x * temp * temp;
            }else {
                return (temp * temp)/x;
            }
        }
    }

}
