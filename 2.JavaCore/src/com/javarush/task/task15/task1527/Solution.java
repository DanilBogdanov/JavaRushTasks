package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String url = reader.readLine();
            String[] params = url.substring(url.indexOf("?") + 1).split("&");
            String result = "";
            ArrayList<String> alertMessage = new ArrayList<>();

            for (String param : params) {
                int indexSplit = param.indexOf("=");
                if (indexSplit == -1) {
                    result += param + " ";
                } else {
                    String p = param.substring(0, indexSplit);
                    result += p + " ";
                    if (p.equals("obj")) {


                        alertMessage.add(param.substring(indexSplit + 1));
                    }
                }
            }

            System.out.println(result);

            for (String alert : alertMessage) {
                try {
                    alert(Double.parseDouble(alert));
                } catch (Exception e) {
                    alert(alert);
                }
            }


            reader.close();
        } catch (Exception e) {
            System.out.println("some trouble");

        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
