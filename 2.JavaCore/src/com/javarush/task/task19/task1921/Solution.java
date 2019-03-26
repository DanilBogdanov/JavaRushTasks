package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*

 */

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        //start(args);
        test();
    }



    private static void test() {
        String text1 = "Иванов Иван Иванович 31 12 1987";
        String text2 = "Вася 15 5 2013";
        String[] argsTest = new String[]{"d:/1.txt"};

        //getPersonFromString(text2);

        start(argsTest);
        PEOPLE.forEach((person) -> System.out.println(person.getName() + "\n" + person.getBirthDate()));
    }

    private static Person getPersonFromString(String string) { //"Иванов Иван Иванович 31 12 1987"
        String name = "";
        Date birthDate = new Date();
        try {
            Pattern pattern = Pattern.compile("([A-zА-я].+[A-zА-я])\\s+(\\d+\\s+\\d+\\s+\\d+)");
            Matcher matcher = pattern.matcher(string);

            while (matcher.find()) {
                name = matcher.group(1).trim();
                //System.out.println(name);//TODO
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
                String stringDate = matcher.group(2).trim();
                 birthDate = simpleDateFormat.parse(stringDate);
            }
        } catch (Exception e) {
            System.out.println("Trouble");
        }

        return new Person(name, birthDate);
    }

    private static Person getPersonFromStringOLD(String string) { //"Иванов Иван Иванович 31 12 1987"
        String name = "";
        Date birthDate = new Date();
        try {
            Pattern patternName = Pattern.compile("[A-zА-я].+[A-zА-я]");
            Pattern patternDate = Pattern.compile("\\d.+\\d");
            Matcher matcherName = patternName.matcher(string);
            Matcher matcherDate = patternDate.matcher(string);

            while (matcherName.find()) {
                name = matcherName.group().trim();

            }

            while (matcherDate.find()) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
                birthDate = simpleDateFormat.parse(matcherDate.group().replaceAll("\\s+", " "));
            }
        } catch (Exception e) {
        }

        name.replaceAll("\\s+", " ");

        return new Person(name, birthDate);
    }


    private static void start(String[] args) {

            String fileName = args[0];

            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                while (fileReader.ready()) {
                    //PEOPLE.add(getPersonFromString(fileReader.readLine()));
                    SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
                    String line = fileReader.readLine();
                    String name = line.replaceAll("\\d", "").trim();
                    String date = line.replace(name, "").trim();
                    System.out.println(date);
                    PEOPLE.add(new Person(name, sdf.parse(date)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

    }


}
