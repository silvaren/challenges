package strings;

import java.util.ArrayList;
import java.util.Scanner;

public class Stack {

    private static Boolean isBalanced(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<Character>();
        int isBalanced = s.chars().reduce(1, (acc, c) -> acc * checkBalancedChar(stack, (char)c));
        return stack.isEmpty() && isBalanced == 1;
    }

    private static int checkBalancedChar(java.util.Stack<Character> stack, char c) {
        char toCheck = ' ';
        switch (c) {
            case '(':
            case '{':
            case '[': stack.push(c); return 1;
            case ')': toCheck = '('; break;
            case '}': toCheck = '{'; break;
            case ']': toCheck = '['; break;
            default: break;
        }
        if (!stack.isEmpty() && stack.peek() == toCheck) {
            stack.pop();
            return 1;
        } else
            return 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> entries = new ArrayList<>();
        while (scan.hasNext()) {
            entries.add(scan.next());
        }
        entries.stream().map(Stack::isBalanced).forEach(System.out::println);
    }

}
