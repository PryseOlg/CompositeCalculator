package parser;

import operation.Number;
import operation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExpressionParser {
    public static Component parse(String expr) {
        expr = normalizeExpression(expr);
        var rpnExpression = RPNParser.parseInRPN(expr);

        return parse(Arrays.stream(rpnExpression.split(" ")).toList());
    }

    private static String normalizeExpression(String expr) {
        var symbols = expr.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char symbol : symbols) {
            if (Character.isDigit(symbol)) {
                sb.append(symbol);
            } else {
                sb.append(" ").append(symbol).append(" ");
            }
        }

        return sb.toString();
    }

    private static Component parse(List<String> rpn) {
        if (rpn.size() == 0) {
            throw new IllegalArgumentException("Invalid number of values");
        }

        Stack<Component> stackCalculation = new Stack<>();
        for (var element : rpn) {
            Component doubleValue = tryParseNumber(element);
            if (doubleValue != null) {
                stackCalculation.push(doubleValue);
            } else if (isOperation(element)) {
                Component second = stackCalculation.pop();
                Component first = stackCalculation.pop();

                stackCalculation.push(calculateOperation(element, first, second));
            } else {
                throw new IllegalArgumentException("Invalid value");
            }
        }

        return stackCalculation.pop();
    }

    private static Component tryParseNumber(String str) {
        try {
            var value = Integer.parseInt(str);
            return new Number(value);
        } catch (Exception e) {
            return null;
        }
    }

    private static Component calculateOperation(String operation, Component first, Component second) {
        return switch (operation) {
            case "+" -> new Add(first, second);
            case "-" -> new Subtraction(first, second);
            case "/" -> new Division(first, second);
            case "*" -> new Multiply(first, second);
            default -> throw new IllegalArgumentException("Invalid operation");
        };
    }

    private static boolean isOperation(String operation) {
        return "+-/*".contains(operation);
    }
}