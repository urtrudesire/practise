package code;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {

    public static void main(String[] args) {
        String s = "Abcdefghijklmnopqrstuvwxyz";
        int n = 3;
        ZigZag zigZag = new ZigZag();
        System.out.println(zigZag.convert(s,n));
    }

    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        List<Integer> base = new ArrayList<>();
        int n = 0;
        while(n < s.length()){
            base.add(n);
            sb.append(s.charAt(n));
            n += 2*numRows - 2;
        }
        base.add(n);
        for(int i = 1; i < numRows; i++){
            for(int b : base){
                if((b-i) > 0 && i != numRows-1 && (b-i) < s.length()) {
                    sb.append(s.charAt(b-i));
                }
                if((b+i) < s.length()) {
                    sb.append(s.charAt(b+i));
                }
            }
        }
        base.clear();
        return sb.toString();
    }
}
