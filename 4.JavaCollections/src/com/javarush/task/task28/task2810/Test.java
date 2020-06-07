package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace(".", "/")
            + "/view/vacancies.html";

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        File file = new File(test.filePath);
        String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36";

        Document document = Jsoup.connect("https://www.petshop.ru/search/?q=royal%20canin").userAgent(USER_AGENT)
                .referrer("").get();

        System.out.println(document.html());
    }
}
