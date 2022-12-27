package gb.homework01;

import java.util.Scanner;

/**
 * Вывести все простые числа от 1 до 1000
 */

public class hw01_2 {

    private static int[] primeNumbers = new int[]{2};

    private static int[] addItemIntoArray(int[] array, int item) {
        int length = array.length;

        int[] temp = new int[length + 1];
        System.arraycopy(array, 0, temp, 0, length);
        temp[length] = item;
        return temp;
    }

    private static boolean isPrime(int n) {
        if (n % 2 == 0) return n == 2;
        for (int primeNumber : primeNumbers) {
            if (n % primeNumber == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Input N: ");
        int n;
        if (iScanner.hasNextInt()) n = iScanner.nextInt();
        else return;

        if (n < 2) return;

        for (int i = 3; i <= n; i += 2) {
            if (isPrime(i)) {
                primeNumbers = addItemIntoArray(primeNumbers, i);
            }
        }

        int i = 0;
        for (int primeNumber : primeNumbers) {
            if (i == 25) {
                System.out.println();
                i = 0;
            }
            System.out.printf("%d ", primeNumber);
            i++;
        }
        System.out.println();
    }
}
