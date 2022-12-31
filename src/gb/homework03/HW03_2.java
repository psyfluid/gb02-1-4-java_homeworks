package gb.homework03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/** Пусть дан произвольный список целых чисел, удалить из него четные числа */

public class HW03_2 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{413, 180, 649, 535, 380, 86, 594, 935, 167, 174};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println(list);
        ListIterator<Integer> iterator = list.listIterator();

        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
