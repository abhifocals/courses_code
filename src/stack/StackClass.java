package stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StackClass {


    public static void main(String[] args) {
        String s = "phone";

        reverseStringConstantSpace(s);

        // 2,5,7
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(7);


        String input = "{}([])";

        boolean answer = balancedParenthesis(input);


    }


    private static boolean balancedParenthesis(String s) {


        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < chars.length; i++) {

            char current = chars[i];

            // If any of closing, Push to Stack.
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            }

            // If Closing Parenthesis and matchesPairing (current, last in Stack), pop, else return false.
            else if (!stack.isEmpty() && (current == ')' || current == '}' || current == ']') && matchesPairing(stack.peek(), current)) {
                stack.pop();
            } else {
                return false;
            }
        }


        // If Stack is empty, return true, else false.

        return stack.isEmpty() ? true : false;

    }


    /*
    Helper for balancedParenthesis
    */

    private static boolean matchesPairing(char opening, char closing) {

        if (opening == '(' && closing == ')') {
            return true;
        }
        if (opening == '{' && closing == '}') {
            return true;
        }
        if (opening == '[' && closing == ']') {
            return true;
        }

        return false;
    }


    /*
    Reverse a  LinkedList using Stack. This moves around data.
    */
    private static void reverseLinkedListUsingStack(List<Integer> input) {

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < input.size(); i++) {
            stack.push(input.get(i));
        }

        input = new LinkedList<>();
        int i = 0;

        while (!stack.empty()) {
            input.add(i, stack.pop());
            i++;
        }
    }


    /*
    Reverse String with Space Complexity of 1.
    */
    private static void reverseStringConstantSpace(String s) {

        int start = 0;
        int end = s.length() - 1;

        StringBuilder sb = new StringBuilder(s);

        while (start < end) {

            Character startChar = s.charAt(start);
            Character endChar = s.charAt(end);

            sb.setCharAt(start, endChar);
            sb.setCharAt(end, startChar);

            start++;
            end--;
        }

        s = sb.toString();

        System.out.println();
    }


    /*
    Reverse String with Space Complexity of n.
     */
    private static void reverseStringSpaceN(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }


}
