import operation.Component;
import parser.ExpressionParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Input expression: ");
        Scanner scanner = new Scanner(System.in);
        String expr = scanner.nextLine();

        Component result = ExpressionParser.parse(expr);

        System.out.println("Calculate result: " + result.getValue());
        System.out.println("Compose tree: " + result);
    }
}