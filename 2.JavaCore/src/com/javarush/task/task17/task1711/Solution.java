package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    addPersonsToArray(args);
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    updatePersonsInArray(args);
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    deleteFromArray(args);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    informationOfPersonFromArray(args);
                }
                break;
        }
    }

    public static synchronized void informationOfPersonFromArray(String[] args) {
        for (int i = 1; i < args.length; i++) {
            int id = Integer.parseInt(args[i]);
            Person person = allPeople.get(id);
            String name = person.getName();
            String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String bd = simpleDateFormat.format(person.getBirthDay());

            System.out.printf("%s %s %s\n", name, sex, bd);
            //System.out.println();
        }
    }

    public static synchronized void deleteFromArray(String[] args) {
        for (int i = 1; i < args.length; i++) {
            int id = Integer.parseInt(args[i]);
            Person person = allPeople.get(id);

            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);
        }
    }

    public static synchronized void updatePersonsInArray(String[] args) {
        for (int i = 1; i < args.length; i += 4) {
            int id = Integer.parseInt(args[i]);
            String name = args[i + 1];
            String sex = args[i + 2];
            String bd = args[i + 3];

            allPeople.set(id, createCorrectPerson(name, sex, bd));
        }
    }

    public static synchronized void addPersonsToArray(String[] args) {
        for (int i = 1; i < args.length; i += 3) {
            String name = args[i];
            String sex = args[i + 1];
            String bd = args[i + 2];

            Person person = createCorrectPerson(name, sex, bd);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
    }

    public static synchronized Person createCorrectPerson(String name, String sex, String bdString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date bd = null;
        try {
            bd = simpleDateFormat.parse(bdString);
        } catch (Exception e) {

        }
        if (sex.equals("м")) {
            return Person.createMale(name, bd);
        } else {
            return Person.createFemale(name, bd);
        }
    }


}
