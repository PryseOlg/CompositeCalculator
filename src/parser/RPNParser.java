package parser;

import java.util.Stack;

public class RPNParser {
    public static String parseInRPN(String expr) {
        StringBuilder resultString = new StringBuilder();
        Stack<Character> operationStack = new Stack<>();
        var chars = expr.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (isDelimiter(chars[i])) {
                continue;
            }

            if (Character.isDigit(chars[i])) {
                while (!isDelimiter(chars[i]) && !isOperation(chars[i])) {
                    resultString.append(chars[i]);
                    i++;

                    if (i == expr.length()) {
                        break;
                    }
                }

                resultString.append(" ");
                i--;
            }

            if (isOperation(chars[i])) {
                if (chars[i] == '(')
                    operationStack.push(chars[i]);
                else if (chars[i] == ')') {
                    char symbol = operationStack.pop();

                    while (symbol != '(') {
                        resultString.append(symbol).append(' ');
                        symbol = operationStack.pop();
                    }
                } else {
                    if (operationStack.size() > 0) {
                        if (getPriority(chars[i]) <= getPriority(operationStack.peek())) {
                            resultString.append(operationStack.pop()).append(" ");
                        }
                    }

                    operationStack.push(chars[i]);
                }
            }
        }

        while (operationStack.size() > 0) {
            resultString.append((char) operationStack.pop()).append(" ");
        }

        return resultString.toString();
    }

    private static boolean isDelimiter(char c) {
        return " =".indexOf(c) != -1;
    }


    private static byte getPriority(char s) {
        return switch (s) {
            case '(' -> 0;
            case ')' -> 1;
            case '+' -> 2;
            case '-' -> 3;
            case '*', '/' -> 4;
            case '^' -> 5;
            default -> 6;
        };
    }

    private static boolean isOperation(char symbol) {
        return "+-/*^()".indexOf(symbol) != -1;
    }
}
