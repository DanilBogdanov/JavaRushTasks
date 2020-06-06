package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    //https://ufa.hh.ru/search/vacancy?area=1&clusters=true&enable_snippets=true&text=java&page=1
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {

        Document document;
        try {
            document= Jsoup.connect(String.format(URL_FORMAT, searchString, 0)).get();
            System.out.print("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
