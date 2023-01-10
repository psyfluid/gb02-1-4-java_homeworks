package gb.homework05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

/**
 * Пусть дан список сотрудников: Иван Иванов (и остальные, полный текст дз будет на платформе)
 * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
 * Отсортировать по убыванию популярности.
 */

public class HW05_2 {
    public static void main(String[] args) throws IOException {
        String fileName = "employees.txt";
        List<String> employees = readFromFile(fileName);
        Map<String, Integer> repeatingEmployees = countEmployees(employees);
        Map<String, Integer> sortedEmployees = sortEmployees(repeatingEmployees);
        for (Entry<String, Integer> entry : sortedEmployees.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            if (v < 2) break;
            System.out.printf("%s: %d%n", k, v);
        }
    }

    private static List<String> readFromFile(String fileName) throws IOException {
        List<String> employees = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String str;
        while ((str = br.readLine()) != null) {
            employees.add(str);
        }
        br.close();
        return employees;
    }

    private static Map<String, Integer> countEmployees(List<String> employees) {
        Map<String, Integer> repeatingEmployees = new HashMap<>();
        for (String employee : employees) {
            repeatingEmployees.compute(employee, (k, v) -> (v == null ? 1 : v + 1));
        }
        return repeatingEmployees;
    }

    private static Map<String, Integer> sortEmployees(Map<String, Integer> repeatingEmployees) {
        LinkedHashMap<String, Integer> sortedEmployees = new LinkedHashMap<>();
        TreeSet<Integer> repetitions = new TreeSet<>(repeatingEmployees.values());
        Iterator<Integer> iterator = repetitions.descendingIterator();
        while (iterator.hasNext()) {
            int repetition = iterator.next();
            repeatingEmployees.forEach((k, v) -> {
                if (v == repetition) {
                    sortedEmployees.put(k, v);
                }
            });
        }
        return sortedEmployees;
    }
}
