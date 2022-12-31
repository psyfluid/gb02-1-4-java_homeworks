package gb.homework03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/** Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка. */

public class HW03_3 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{64, 21, 78, 27, 59};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println(list);
        ListIterator<Integer> iterator = list.listIterator();
        int sum = iterator.next();
        int min = sum;
        int max = sum;
        while (iterator.hasNext()) {
            int current = iterator.next();
            if (min > current) min = current;
            if (max < current) max = current;
            sum += current;
        }
        double mean = (double) sum / list.size();
        System.out.printf("min = %d, max = %d, mean = %.3f\n", min, max, mean);
    }
}
