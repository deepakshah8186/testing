package General;

import java.util.LinkedList;
import java.util.Stack;

public class InfixToPostfix {

    // Helper method to check if a character is an operand
    public static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    // Helper method to check the precedence of an operator
    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Helper method to convert infix expression to postfix
    public static String infixToPostfix(String expression) {
        LinkedList<Character> output = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (isOperand(ch)) {
                output.add(ch);
            }
            // If the character is '(', push it to the stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If the character is ')', pop from the stack until '(' is encountered
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.add(stack.pop());
                }
                stack.pop(); // Pop '(' from the stack
            }
            else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    output.add(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop all remaining operators from the stack
        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        // Convert LinkedList output to a String
        StringBuilder result = new StringBuilder();
        for (char c : output) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String infix = "A+B*(C^D-E)"; // "A+B*(C^D-E)^(F+G*H)-I";
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + infixToPostfix(infix));
    }
}

