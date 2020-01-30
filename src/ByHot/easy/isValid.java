package ByHot.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValid {

    //
    private HashMap<Character, Character> map;
    public isValid(){
        this.map = new HashMap<Character, Character>();
        this.map.put(')', '(');
        this.map.put(']', '[');
        this.map.put('}', '{');
    }
    public boolean solution1(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (this.map.containsKey(ch)) {
                char top = stack.empty() ? '#' : stack.pop();
                if (top != this.map.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
