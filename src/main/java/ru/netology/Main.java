package ru.netology;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        CatFactFetcher fetcher = new CatFactFetcher();
        try {
            List<CatFact> catFacts = fetcher.fetchCatFacts();

            // Фильтрация по upvotes > 0
            List<CatFact> filteredFacts = catFacts.stream()
                    .filter(fact -> fact.getUpvotes() != null && fact.getUpvotes() > 0)
                    .collect(Collectors.toList());

            // Вывод результата
            filteredFacts.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}