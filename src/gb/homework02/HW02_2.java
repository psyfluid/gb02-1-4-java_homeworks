package gb.homework02;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */

public class HW02_2 {

    private static final Logger logger = Logger.getLogger(HW02_2.class.getName());

    public static void main(String[] args) throws IOException {
        FileHandler fileHandler = new FileHandler("sort.log");
        logger.addHandler(fileHandler);
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);
        logger.setLevel(Level.INFO);

        int[] randomArray = new int[]{936, 447, 901, 567, 631};
        bubbleSort(randomArray);

        System.out.println();
        for (int i : randomArray) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    private static void bubbleSort(int[] array) {
        logger.info(Arrays.toString(array));
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    logger.info(Arrays.toString(array));
                }
            }
        }
    }
}
