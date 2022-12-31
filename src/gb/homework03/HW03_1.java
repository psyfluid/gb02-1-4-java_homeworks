package gb.homework03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Реализовать алгоритм сортировки слиянием
 */

public class HW03_1 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{11, 86, 76, 19, 73, 39, 83, 85, 15, 4};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println(list);

        List<Integer> sortedList = mergesort(list, 0, list.size() - 1);
        System.out.println(sortedList);
    }

    private static List<Integer> mergesort(List<Integer> list, int left, int right) {
        if (left < right) {
            int median = (left + right) / 2;
            return merge(mergesort(list, left, median), mergesort(list, median + 1, right));
        }
        return list.subList(left, left + 1);
    }

    private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> newList = new ArrayList<>();
        int len1 = list1.size();
        int len2 = list2.size();
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            int num1 = list1.get(i);
            int num2 = list2.get(j);
            if (num1 <= num2) {
                newList.add(num1);
                i++;
            } else {
                newList.add(num2);
                j++;
            }
        }
        if (j >= len2) {
            newList.addAll(list1.subList(i, len1));
        } else {
            newList.addAll(list2.subList(j, len2));
        }
        return newList;
    }
}
