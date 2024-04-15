package Code;

// Java program for the above approach

import java.util.Stack;

class StringMod {

    public static String removeKdigits(String num, int k)
    {
        StringBuilder result = new StringBuilder();

        // We have to delete all digits
        if (k >= num.length()) {
            return "0";
        }
        // Nothing to delete
        if (k == 0) {
            return num;
        }
        Stack<Character> s = new Stack<Character>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            // Removing all digits in stack that are greater
            // than this digit(since they have higher
            // weightage)
            while (!s.isEmpty() && k > 0 && s.peek() > c) {
                s.pop();
                k--;
            }
            // ignore pushing 0
            if (!s.isEmpty() || c != '0')
                s.push(c);
        }

        // If our k isnt 0 yet then we keep popping out the
        // stack until k becomes 0
        while (!s.isEmpty() && k > 0) {
            k--;
            s.pop();
        }
        if (s.isEmpty())
            return "0";
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        String str = result.reverse().toString();

        return str;
    }

    // Driver Code
    public static void main(String[] args)
    {
        String s = "765028321";
        int k = 5;
        System.out.println(removeKdigits(s, 5));
    }
}
// this code is contributed by gireeshgudaparthi
