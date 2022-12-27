package gb.homework01;

import java.util.Scanner;

/**
 * Реализовать простой калькулятор
 */

public class hw01_3 {

    private static String getResult(String expression) {
        try {
            return calcExpr(expression);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private static String calcExpr(String expression) {
        int leftPar = 0;
        int rightPar = 0;
        int leftIndex = -1;
        int rightIndex = expression.length();
        for (int i = 0; i < expression.length(); i++) {
            if (leftPar > 0 && rightPar > 0) {
                leftPar = -1;
                rightPar = -1;
                return calcExpr(String.format("%s%s%s", expression.substring(0, leftIndex),
                        calcExpr(expression.substring(leftIndex + 1, rightIndex)),
                        expression.substring(rightIndex + 1)));
            }
            if (expression.charAt(i) == '(') {
                leftPar += 1;
                leftIndex = i;
            } else if (expression.charAt(i) == ')') {
                rightPar += 1;
                rightIndex = i;
            }
        }

        if (leftPar > 0) {
            return calcExpr(String.format("%s%s%s", expression.substring(0, leftIndex),
                    calcExpr(expression.substring(leftIndex + 1, rightIndex)),
                    expression.substring(rightIndex + 1)));
        } else {
            return calcInside(expression.substring(leftIndex + 1, rightIndex));
        }

    }

    private static boolean isNumber(String n) {
        try {
            Double.parseDouble(n);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String calcInside(String expression) {
        int i;
        if (expression.isEmpty()) {
            return "";
        } else if (isNumber(expression)) {
            return expression;
        } else if ((i = expression.indexOf('+')) > 0) {
            return String.valueOf(
                    Double.parseDouble(calcInside(expression.substring(0, i)))
                            + Double.parseDouble(calcInside(expression.substring(i + 1)))
            );
        } else if ((i = expression.indexOf('-', 1)) > 0) {
            if (expression.charAt(i - 1) == '*' || expression.charAt(i - 1) == '/') {
                return String.valueOf(
                        -1 * Double.parseDouble(
                                calcInside(String.format("%s%s%s", calcInside(expression.substring(0, i - 1)),
                                        expression.charAt(i - 1),
                                        calcInside(expression.substring(i + 1))))
                        )
                );
            } else if (expression.charAt(i - 1) == '+') {
                return String.valueOf(
                        Double.parseDouble(calcInside(expression.substring(0, i - 1)))
                                - Double.parseDouble(calcInside(expression.substring(i + 1)))
                );
            } else if (expression.charAt(i - 1) == '-') {
                return String.valueOf(
                        Double.parseDouble(calcInside(expression.substring(0, i - 1)))
                                + Double.parseDouble(calcInside(expression.substring(i + 1)))
                );
            } else {
                return String.valueOf(
                        Double.parseDouble(calcInside(expression.substring(0, i)))
                                - Double.parseDouble(calcInside(expression.substring(i + 1)))
                );
            }
        } else if ((i = expression.indexOf('*')) > 0) {
            return String.valueOf(
                    Double.parseDouble(calcInside(expression.substring(0, i)))
                            * Double.parseDouble(calcInside(expression.substring(i + 1)))
            );
        } else if ((i = expression.indexOf('/')) > 0) {
            return String.valueOf(
                    Double.parseDouble(calcInside(expression.substring(0, i)))
                            / Double.parseDouble(calcInside(expression.substring(i + 1)))
            );
        }
        return "";
    }


    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Input expression: ");
        String expr = iScanner.nextLine();
        expr = expr.replace(" ", "").replace(",", ".");

        System.out.printf("%s = %s%n", expr, getResult(expr));
    }
}
