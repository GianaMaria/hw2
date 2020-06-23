package lesson3;

import java.util.*;

public class PhoneBook {

    Map<String, ArrayList<String>> phoneBook = new HashMap<>();

    void set() {
        phoneBook.put("Rimuru", new ArrayList<>(Arrays.asList("+79145886914")));
        phoneBook.put("Missio", new ArrayList<>(Arrays.asList("+79245683514")));
        phoneBook.put("Golberg", new ArrayList<>(Arrays.asList("+78082468235", "+79693645681", "+79856235532")));
        phoneBook.put("Giana", new ArrayList<>(Arrays.asList("+79002568423")));
        phoneBook.put("Gromova", new ArrayList<>(Arrays.asList("+79244488025", "+79245623573")));
    }

    void add(String lastName, String phone) {
        ArrayList<String> numbers;

        if (phoneBook.containsKey(lastName)) {
            numbers = phoneBook.get(lastName);
        } else {
            numbers = new ArrayList<>();
        }
        numbers.add(phone);
        phoneBook.put(lastName, numbers);

    }

    void get(String lastName) {
        System.out.println("Номер(a) пользователя " + lastName + ": " + phoneBook.get(lastName));
    }

}
