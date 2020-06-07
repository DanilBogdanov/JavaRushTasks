package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    //https://ufa.hh.ru/search/vacancy?area=1&clusters=true&enable_snippets=true&text=java&page=1
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
    private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36";
    private static final String REFFERER = "";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            Document document = getDocument(searchString, 0);
            int numOfPages = document.getElementsByAttributeValue("data-qa", "pager-page").size();
            int page = 0;
            while (true) {
                document = getDocument(searchString, page);
                Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");

                if (elements.size() == 0) {
                    break;
                }
                for (Element el : elements) {
                    //title  data-qa="vacancy-serp__vacancy-title"
                    //salary data-qa="vacancy-serp__vacancy-compensation"
                    //city   data-qa="vacancy-serp__vacancy-address"
                    //companyName data-qa="vacancy-serp__vacancy-employer"
                    //siteName; url_format
                    //url; element.getElementsByAttributeValueContaining("data-qa", "title").attr("href")
                    Vacancy vacancy = new Vacancy();
                    String title = el.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text();
                    String salary = el.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text();
                    String city = el.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text();
                    String companyName = el.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text();
                    String siteName = String.format(URL_FORMAT, searchString, page);
                    String url = el.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href");

                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    //System.out.println(vacancy);
                    vacancies.add(vacancy);
                }
                //data-qa="pager-next"


                page++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {

        Document document = Jsoup.connect(String.format(URL_FORMAT, searchString, page)).userAgent(USER_AGENT)
                .referrer(REFFERER).get();

        /*String testURL = "http://javarush.ru/testdata/big28data.html";
        Document testDocument = Jsoup.connect(testURL).userAgent(USER_AGENT)
                .referrer(REFFERER).get();*/
        return document;
    }
}
