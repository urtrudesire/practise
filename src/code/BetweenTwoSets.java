package code;

import java.util.List;

public class BetweenTwoSets {
    /*
    There will be two arrays of integers. Determine all integers that satisfy the following two conditions:

The elements of the first array are all factors of the integer being considered
The integer being considered is a factor of all elements of the second array
These numbers are referred to as being between the two arrays. Determine how many such numbers exist.

Example
a= [2,6]
b= [24,36]
There are two numbers between the arrays:  6 and 12.
6%2=0, 6%6=0, 24%6=0 and 36%6=0 for the first value.
12%2=0, 12%6=0, 24%12=0 and 36%12=0 for the second value. Return 2.
     */

    public Integer result(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null || list1.isEmpty() || list2.isEmpty()) {
            return 0;
        }
        int start = list1.get(list1.size()-1);
        int end = list2.get(0);
        int result = 0;

        for (int i = start; i <= end; i++) {
            boolean check = true;
            for (Integer integer : list1) {
                if (i % integer != 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                for (Integer integer : list2) {
                    if (integer % i != 0) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) result++;
        }
        return result;
    }
}
