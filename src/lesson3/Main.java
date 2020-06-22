package lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("океан", "скалы", "океан",
                "небо", "книга", "океан", "гроза", "закат", "темнота", "книга", "закат", "океан"));

        Map<String, Integer> wordsUnique = new HashMap<>();
        for (String word : words) {
            Integer value = wordsUnique.getOrDefault(word, 0);
            wordsUnique.put(word, value + 1);
        }

        System.out.print("Уникальные слова: ");

        wordsUnique.forEach((k, v) -> {
            if (v == 1) {
                System.out.print(k + " ");
            }
        });

        System.out.println("\n" + wordsUnique);
        System.out.println();

        PhoneBook pb = new PhoneBook();
        pb.set();

        pb.add("Ivanov", "+79145332689");
        pb.add("Sokolov", "+79145889624");
        pb.add("Sokolov", "+79614788565");
        pb.add("Ivanov", "+79244458264");

        pb.get("Sokolov");
        pb.get("Giana");

    }

}
