package gb.homework05;

import java.util.*;

/**
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */

public class HW05_1 {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();

        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose action: ");
            System.out.println("0 - Show phone book");
            System.out.println("1 - Show person contacts");
            System.out.println("2 - Add phone");
            System.out.println("3 - Delete phone");
            System.out.println("4 - Delete person");
            System.out.println("5 - Exit");

            String action = iScanner.next();
            int actionId;
            try {
                actionId = Integer.parseInt(action);
            } catch (Exception e) {
                continue;
            }

            if (actionId == 0) {
                if (phoneBook.isEmpty()) {
                    System.out.println("Phone book is empty.");
                }
                phoneBook.forEach((name, phones) -> {
                    showPersonContacts(name, phones);
                });
                continue;
            } else if (actionId == 5) {
                return;
            } else if (actionId < 0 || actionId > 5) {
                continue;
            }

            System.out.print("Enter the person's name: ");
            String name = iScanner.next();

            List<String> phones = getPersonContacts(phoneBook, name);

            switch (actionId) {
                case 1 -> {
                    if (!phoneBook.containsKey(name)) {
                        System.out.printf("Person '%s' not found.%n", name);
                        break;
                    }
                    showPersonContacts(name, phones);
                }
                case 2 -> {
                    System.out.print("Enter phone number to add: ");
                    String phone = iScanner.next();
                    phones.add(phone);
                    phoneBook.put(name, phones);
                }
                case 3 -> {
                    System.out.print("Enter phone number to delete: ");
                    String phoneDeleting = iScanner.next();
                    phones.removeIf(s -> s.equals(phoneDeleting));
                    phoneBook.put(name, phones);
                }
                case 4 -> {
                    phoneBook.remove(name);
                    System.out.printf("Person '%s' has been removed.%n", name);
                }
            }
        }
    }

    private static void showPersonContacts(String name, List<String> phones) {
        System.out.printf("%s: %n", name);
        System.out.println(phones);
    }

    private static List<String> getPersonContacts(Map<String, List<String>> phoneBook, String name) {
        List<String> phones;
        phones = phoneBook.get(name);
        if (phones == null) {
            // System.out.println("Person not found");
            phones = new ArrayList<>();
        }
        return phones;
    }
}
