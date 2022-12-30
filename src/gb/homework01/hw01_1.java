package gb.homework01;

import java.util.Scanner;

/**
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 */

public class hw01_1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Input N: ");
        int n;
        if (iScanner.hasNextInt()) n = iScanner.nextInt();
        else return;

        int nSum = 0;
        int nFactorial = 1;
        for (int i = 1; i <= n; i++) {
            nSum += i;
            nFactorial *= i;
        }
        System.out.printf("Sum from 1 to %d = %d%n", n, nSum);
        System.out.printf("%d! = %d%n", n, nFactorial);
    }
}
