package code;

import java.util.List;

public class SamTree {

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here
        long A = 0, O = 0;
        A = apples.stream().filter(apple -> (apple+a) >= s && (apple+a) <= t).count();
        O = oranges.stream().filter(orange -> (orange+b) >= s && (orange+b) <= t).count();
        System.out.println(A);
        System.out.println(O);
    }

    public static void main(String[] args) {

    }
}
