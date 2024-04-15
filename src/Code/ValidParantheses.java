package Code;

import java.util.List;
import java.util.Stack;

public class ValidParantheses {

    public static void main(String[] args) {
        ValidParantheses validParantheses = new ValidParantheses();
        String s = "(}";
        System.out.println(validParantheses.isValid(s));
    }

    public boolean isValid(String s) {
        List<Character> open = List.of('(', '{', '[');
        List<Character> close = List.of(')', '}', ']');
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index < s.length()){
            char c = s.charAt(index);
            if(open.contains(c)){
                stack.add(c);
            } else {
                if(!stack.isEmpty() && (open.indexOf(stack.peek()) == close.indexOf(c))){
                    stack.pop();
                }else
                    return false;
            }
            index++;
        }
        return stack.isEmpty();
    }
}
