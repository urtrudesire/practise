package Code;

import java.util.ArrayList;
import java.util.List;

public class GradingResult {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        grades.forEach(grade -> {
            if(grade > 37 ){
                int n = grade%10;
                int s = 0;
                if(n > 5){
                    n = n%5;
                }
                s = 5-n;
                if ( s < 3){
                    result.add(grade + s);
                }
                else {
                    result.add(grade);
                }
            }else {
                result.add(grade);
            }
        });
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(73);
        list.add(67);
        list.add(38);
        list.add(33);
        gradingStudents(list).forEach(System.out::println);
    }
}
