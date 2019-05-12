package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        //String fileName = "/home/danil/test/1.txt";//todo
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {

            //add all strings from file to List
            ArrayList<String> strings = new ArrayList<>();
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                for (String string : line.split(" +")) {
                    strings.add(string);
                }
            }

            //check list for Pairs
            int length = strings.size();
            String firstString;
            String secondString;
            String reverseString;

            for (int i = 0; i < length - 1; i++) {
                firstString = strings.get(i);
                for (int y = i + 1; y < length; y++) {
                    secondString = strings.get(y);
                    reverseString = new StringBuilder(secondString).reverse().toString();
                    if (firstString.equals(reverseString)) {
                        Pair pair = new Pair();
                        pair.first = firstString;
                        pair.second = secondString;
                        if (!result.contains(pair)) {
                            result.add(pair);
                        }
                    }
                }
            }




//            for (Pair pair : result) {
//                System.out.println(pair);
//            }

        } catch (IOException e) {

        }

    }

    public List<Pair> getPairs (String[] strings) {
        List<Pair> result = new ArrayList<>();

        

        return result;
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
