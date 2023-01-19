package gb.homework06;

import java.util.*;

public class HW06 {
    public static void main(String[] args) {
        Set<Notebook> notebooks = initializeNotebooks();
        Map<String, Object> filters = getFiltersFromUser();
        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filters);
        filteredNotebooks.forEach(System.out::println);
    }

    private static Set<Notebook> initializeNotebooks() {
        Notebook nb1 = new Notebook(Colour.WHITE);
        nb1.setOs(OS.WINDOWS);
        nb1.setRam(RAM.GB_8);
        nb1.setHdd(HDD.GB_128);

        Notebook nb2 = new Notebook(Colour.SILVER);
        nb2.setOs(OS.MACOS);
        nb2.setRam(RAM.GB_16);
        nb2.setHdd(HDD.GB_128);

        Notebook nb3 = new Notebook(Colour.GREY);
        nb3.setOs(OS.MACOS);
        nb3.setRam(RAM.GB_32);
        nb3.setHdd(HDD.GB_256);

        Notebook nb4 = new Notebook(Colour.GREY);
        nb4.setOs(OS.MACOS);
        nb4.setRam(RAM.GB_64);
        nb4.setHdd(HDD.GB_512);

        Notebook nb5 = new Notebook(Colour.WHITE);
        nb5.setOs(OS.LINUX);
        nb5.setRam(RAM.GB_32);
        nb5.setHdd(HDD.GB_256);

        Notebook nb6 = new Notebook(Colour.WHITE);
        nb6.setOs(OS.LINUX);
        nb6.setRam(RAM.GB_32);
        nb6.setHdd(HDD.GB_512);

        Notebook nb7 = new Notebook(Colour.BLACK);
        nb7.setOs(OS.LINUX);
        nb7.setRam(RAM.GB_64);
        nb7.setHdd(HDD.GB_512);

        Notebook nb8 = new Notebook(Colour.ORANGE);
        nb8.setOs(OS.LINUX);
        nb8.setRam(RAM.GB_128);
        nb8.setHdd(HDD.GB_1024);

        return new TreeSet<>(Arrays.asList(nb1, nb2, nb3, nb4, nb5, nb6, nb7, nb8));
    }

    private static Map<String, Object> getFiltersFromUser() {
        Map<String, Object> filters = new HashMap<>();

        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the required parameters: ");
            System.out.println("0 - Colour");
            System.out.println("1 - OS");
            System.out.println("2 - RAM");
            System.out.println("3 - HDD");
            System.out.println("4 - Confirm choice and filter notebooks");

            String action = iScanner.next();
            int actionId;
            try {
                actionId = Integer.parseInt(action);
            } catch (Exception e) {
                continue;
            }

            if (actionId == 4) {
                return filters;
            } else if (actionId < 0 || actionId > 5) {
                continue;
            }

            switch (actionId) {
                case 0 -> enumChoice(iScanner, filters, Colour.class);
                case 1 -> enumChoice(iScanner, filters, OS.class);
                case 2 -> enumChoice(iScanner, filters, RAM.class);
                case 3 -> enumChoice(iScanner, filters, HDD.class);
            }
        }
    }

    private static void enumChoice(Scanner iScanner, Map<String, Object> filters, Class<?> enumClass) {
        List<?> enumList = Arrays.asList(enumClass.getEnumConstants());
        String enumName = enumClass.getSimpleName();
        int length = enumList.size();
        while (true) {
            System.out.printf("Choose %s:%n", enumName);
            for (int i = 0; i < length; i++) {
                System.out.printf("%d - %s%n", i, enumList.get(i));
            }
            System.out.printf("%d - Cancel%n", length);

            String action = iScanner.next();
            int actionId;
            try {
                actionId = Integer.parseInt(action);
            } catch (Exception e) {
                continue;
            }

            if (actionId == length) {
                break;
            } else if (actionId < 0 || actionId > length) {
                continue;
            }

            filters.put(enumName, enumList.get(actionId));
            break;
        }
    }


    private static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, Object> filters) {
        Set<Notebook> filteredNotebooks = new TreeSet<>();
        notebooks.forEach(notebook -> {
            if (compareNotebookToFilters(notebook, filters)) {
                filteredNotebooks.add(notebook);
            }
        });
        return filteredNotebooks;
    }

    private static boolean compareNotebookToFilters(Notebook notebook, Map<String, Object> filters) {
        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String k = entry.getKey();
            Object v = entry.getValue();

            switch (k) {
                case "Colour" -> {
                    if (notebook.getColour() != v) return false;
                }
                case "OS" -> {
                    if (notebook.getOs() != v) return false;
                }
                case "RAM" -> {
                    if (notebook.getRam().getSize() < ((RAM) v).getSize()) return false;
                }
                case "HDD" -> {
                    if (notebook.getHdd().getSize() < ((HDD) v).getSize()) return false;
                }
            }
        }
        return true;
    }
}
