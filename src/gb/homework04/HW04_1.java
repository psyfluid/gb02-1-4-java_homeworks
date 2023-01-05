package gb.homework04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Пусть дан LinkedList с несколькими элементами. <br/>
 * Реализуйте метод, который вернет “перевернутый” список.
 */

public class HW04_1 {
    public static void main(String[] args) {
        Random random = new Random();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println("Original list:");
        System.out.println(list);
        System.out.println("Reversed list:");
        System.out.println(reversedList(list));
        System.out.println("Reversed list with descending iterator:");
        System.out.println(reversedListWithIterator(list));
    }

    private static LinkedList<Integer> reversedList(LinkedList<Integer> list) {
        LinkedList<Integer> newList = new LinkedList<Integer>();
        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }
        return newList;
    }

    private static LinkedList<Integer> reversedListWithIterator(LinkedList<Integer> list) {
        LinkedList<Integer> newList = new LinkedList<Integer>();
        Iterator<Integer> iterator = list.descendingIterator();
        while (iterator.hasNext()) {
            newList.add(iterator.next());
        }
        return newList;
    }
}
